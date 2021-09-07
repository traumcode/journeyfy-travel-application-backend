package com.journeyfy.journeyfytravelapplication.users;


import com.journeyfy.journeyfytravelapplication.exception.TokenRefreshException;
import com.journeyfy.journeyfytravelapplication.payload.request.LogOutRequest;
import com.journeyfy.journeyfytravelapplication.payload.request.LoginRequest;
import com.journeyfy.journeyfytravelapplication.payload.request.SignUpRequest;
import com.journeyfy.journeyfytravelapplication.payload.request.TokenRefreshRequest;
import com.journeyfy.journeyfytravelapplication.payload.response.JwtResponse;
import com.journeyfy.journeyfytravelapplication.payload.response.MessageResponse;
import com.journeyfy.journeyfytravelapplication.payload.response.TokenRefreshResponse;
import com.journeyfy.journeyfytravelapplication.security.jwt.JwtUtils;
import com.journeyfy.journeyfytravelapplication.security.models.RefreshToken;
import com.journeyfy.journeyfytravelapplication.security.services.RefreshTokenService;
import com.journeyfy.journeyfytravelapplication.security.services.UserDetailsImplementation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    RefreshTokenService refreshTokenService;

    @DeleteMapping(path = "/{id}/delete")
    public void deleteUserById(@PathVariable(value = "id") Long id){
        userRepository.delete(userRepository.getById(id));
    }

    @GetMapping(path = "/all-users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping(path = "/{username}")
    public User getUserProfileByUsername(@PathVariable(value = "username") String username) {
        return userRepository.findByUsername(username).get();
    }


    @GetMapping(path = "/my-profile/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public User getUserByIdForProfilePage(@PathVariable(value = "id") Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info(authentication.getName());
        log.info((String) authentication.getPrincipal());
        return userRepository.findById(id).get();
    }

    //TODO update user info

    @PatchMapping(path = "/edit-profile")
    public User editUserProfile(@RequestBody User user) {
        return null;
    }

    @PostMapping(path="/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImplementation userDetailsImplementation = (UserDetailsImplementation) authentication.getPrincipal();
        String jwt = jwtUtils.generateJwtToken(userDetailsImplementation);
        List<String> roles = userDetailsImplementation.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetailsImplementation.getId());
        return ResponseEntity.ok(new JwtResponse(jwt, refreshToken.getToken(), userDetailsImplementation.getId(), userDetailsImplementation.getUsername(),
                userDetailsImplementation.getEmail(), roles));
    }

    @PostMapping(path = "/add-user")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error, username is already taken"));
        }
        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error, email is already taken"));
        }

        User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(), passwordEncoder.encode(signUpRequest.getPassword()), signUpRequest.getGender());
        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();
        log.info(roleRepository.findByName(UserRole.ROLE_USER).toString());
        if(strRoles == null){
            Role userRole = roleRepository.findByName(UserRole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("error: Role is not found."));
            roles.add(userRole);
        }else{
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

    @PostMapping("/refreshtoken")
    public ResponseEntity<?> refreshtoken(@Valid @RequestBody TokenRefreshRequest request) {
        String requestRefreshToken = request.getRefreshToken();

        return refreshTokenService.findByToken(requestRefreshToken)
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUser)
                .map(user -> {
                    String token = jwtUtils.generateTokenFromUsername(user.getUsername());
                    return ResponseEntity.ok(new TokenRefreshResponse(token, requestRefreshToken));
                })
                .orElseThrow(() -> new TokenRefreshException(requestRefreshToken,
                        "Refresh token is not in database!"));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser(@Valid @RequestBody LogOutRequest logOutRequest) {
        refreshTokenService.deleteByUserId(logOutRequest.getUserId());
        return ResponseEntity.ok(new MessageResponse("Log out successful!"));
    }

//    public User findUser(@RequestBody User user) {
//        if(userRepository.getUserByUsernameAndPassword(user.getUsername(), user.getPassword()) == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
//        return userRepository.getUserByUsernameAndPassword(user.getUsername(), user.getPassword());
//    }

//    @PostMapping(path = "/add-user")
//    public void addUser(@RequestBody User user){
//        userRepository.save(user);
//    }
}
