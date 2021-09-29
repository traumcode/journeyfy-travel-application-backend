package com.journeyfy.journeyfytravelapplication.users;
import com.journeyfy.journeyfytravelapplication.exception.domain.EmailExistException;
import com.journeyfy.journeyfytravelapplication.exception.domain.UserNotFoundException;
import com.journeyfy.journeyfytravelapplication.exception.domain.UsernameExistException;
import com.journeyfy.journeyfytravelapplication.payload.request.LoginRequest;
import com.journeyfy.journeyfytravelapplication.payload.request.SignUpRequest;
import com.journeyfy.journeyfytravelapplication.payload.response.JwtResponse;
import com.journeyfy.journeyfytravelapplication.payload.response.MessageResponse;
import com.journeyfy.journeyfytravelapplication.security.jwt.JwtUtils;
import com.journeyfy.journeyfytravelapplication.security.services.UserDetailsImplementation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/user")
@AllArgsConstructor
@CrossOrigin
@Slf4j
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;
    RoleRepository roleRepository;
    AuthenticationManager authenticationManager;
    JwtUtils jwtUtils;
    PasswordEncoder passwordEncoder;


    @GetMapping(path = "/all-users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/profile/{username}")
    public ResponseEntity<User> getUserProfileById(@PathVariable(value = "username") String username) {
        return new ResponseEntity<>(userService.findByUserName(username), HttpStatus.OK);
    }

    @PutMapping(path = "/profile/{id}/edit-profile/{currentUsername}")
    public ResponseEntity<User> editUserProfile(@PathVariable(value = "id") Long id, @PathVariable(value = "currentUsername") String currentUsername, @RequestBody User user) throws UserNotFoundException, UsernameExistException, EmailExistException {
        User forResponse = userService.updateUser(id, currentUsername, user);
        return new ResponseEntity<>(forResponse, HttpStatus.OK);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImplementation userDetailsImplementation = (UserDetailsImplementation) authentication.getPrincipal();

        List<String> roles = userDetailsImplementation.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        log.info(String.valueOf(roles));
        String jwt = jwtUtils.generateJwtToken(loginRequest.getUsername(), roles);
        return ResponseEntity.ok(new JwtResponse(jwt, userDetailsImplementation.getId(), userDetailsImplementation.getUsername(),
                userDetailsImplementation.getEmail(), roles));
    }

    @PostMapping(path = "/add-user")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error, username is already taken"));
        }
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error, email is already taken"));
        }

        User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(), passwordEncoder.encode(signUpRequest.getPassword()), signUpRequest.getGender());
        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(UserRole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin" -> {
                        Role adminRole = roleRepository.findByName(UserRole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                    }
                    case "mod" -> {
                        Role modRole = roleRepository.findByName(UserRole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);
                    }
                    default -> {
                        Role userRole = roleRepository.findByName(UserRole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                    }
                }
            });
        }
        user.setRoles(roles);
        user.setJoinedDate(LocalDate.now());
        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));

    }


    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser() {
        SecurityContextHolder.clearContext();
        return ResponseEntity.ok(new MessageResponse("Log out successful!"));
    }

    @DeleteMapping("/{username}/delete")
    @Transactional
    public ResponseEntity<?> deleteUser(@PathVariable("username") String username) {
        User user = userRepository.findByUsername(username).get();
        userRepository.delete(user);
        return ResponseEntity.ok(new MessageResponse("Deleted successfully!"));
    }
}


