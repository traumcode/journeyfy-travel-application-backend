package com.journeyfy.journeyfytravelapplication.users;


import com.journeyfy.journeyfytravelapplication.advice.ErrorMessage;
import com.journeyfy.journeyfytravelapplication.exception.TokenRefreshException;
import com.journeyfy.journeyfytravelapplication.payload.request.LogOutRequest;
import com.journeyfy.journeyfytravelapplication.payload.request.LoginRequest;
import com.journeyfy.journeyfytravelapplication.payload.request.SignUpRequest;
import com.journeyfy.journeyfytravelapplication.payload.request.TokenRefreshRequest;
import com.journeyfy.journeyfytravelapplication.payload.response.JwtResponse;
import com.journeyfy.journeyfytravelapplication.payload.response.MessageResponse;
import com.journeyfy.journeyfytravelapplication.payload.response.TokenRefreshResponse;
import com.journeyfy.journeyfytravelapplication.security.jwt.JwtUtils;
import com.journeyfy.journeyfytravelapplication.security.services.UserDetailsImplementation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/user")
@AllArgsConstructor
@CrossOrigin
@Slf4j
public class UserController {
    private final UserRepository userRepository;
    RoleRepository roleRepository;
    AuthenticationManager authenticationManager;
    JwtUtils jwtUtils;
    PasswordEncoder passwordEncoder;


    @GetMapping(path = "/all-users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/profile/{username}")
    public User getUserProfileByUsername(@PathVariable(value = "username") String username) {
        return userRepository.findByUsername(username).get();
    }

    //TODO update user info

    @PatchMapping(path = "/profile/{username}/edit-profile")
    public void editUserProfile(@PathVariable(value = "username") String username, @RequestBody User user, Principal principal) {
        Optional<User> userFound = userRepository.findByUsername(username);
        if (userFound.isPresent()) {
            if (Objects.equals(userFound.get().getUsername(), principal.getName())) {
                userFound.get().setUsername(user.getUsername());
                userFound.get().setEmail(user.getEmail());
                userFound.get().setCity(user.getCity());
                userFound.get().setCountry(user.getCountry());
                userFound.get().setDescription(user.getDescription());
                userFound.get().setGender(user.getGender());
                userFound.get().setJoinedDate(user.getJoinedDate());
                userFound.get().setRoles(userFound.get().getRoles());
                userFound.get().setPassword(userFound.get().getPassword());
                userRepository.save(userFound.get());
            } else {
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not allowed to edit this profile");
            }
        }
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImplementation userDetailsImplementation = (UserDetailsImplementation) authentication.getPrincipal();
        String jwt = jwtUtils.generateJwtToken(userDetailsImplementation);
        List<String> roles = userDetailsImplementation.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
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
        log.info(roleRepository.findByName(UserRole.ROLE_USER).toString());
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


