package com.journeyfy.journeyfytravelapplication.users;

import com.journeyfy.journeyfytravelapplication.exception.domain.EmailExistException;
import com.journeyfy.journeyfytravelapplication.exception.domain.UserNotFoundException;
import com.journeyfy.journeyfytravelapplication.exception.domain.UsernameExistException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public User findByUserName(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Could not find user with username: " + username));
    }

    public User updateUser(Long id, String currentUsername, User updatedUser) throws UserNotFoundException, UsernameExistException, EmailExistException {
        User currentUser = validateNewUserNameAndEmail(id, currentUsername, updatedUser.getUsername(), updatedUser.getEmail());
        currentUser.setUsername(updatedUser.getUsername());
        currentUser.setEmail(updatedUser.getEmail());
        currentUser.setCity(updatedUser.getCity());
        currentUser.setCountry(updatedUser.getCountry());
        currentUser.setDescription(updatedUser.getDescription());
        currentUser.setGender(updatedUser.getGender());
        currentUser.setJoinedDate(currentUser.getJoinedDate());
        currentUser.setRoles(currentUser.getRoles());
        currentUser.setPassword(currentUser.getPassword());
        userRepository.save(currentUser);
        return currentUser;
    }


    private User validateNewUserNameAndEmail(Long id, String currentUsername, String newUsername, String newEmail) throws UserNotFoundException, UsernameExistException, EmailExistException {
        User userByNewUsername = userRepository.findUserByUsername(newUsername);
        User userByNewEmail = userRepository.findUserByEmail(newEmail);
        if (StringUtils.isNotBlank(currentUsername)) {
            User currentUser = findByUserName(currentUsername);
            if (currentUser == null) {
                throw new UserNotFoundException("No user found by username: " + currentUsername + "!");
            }
            if (userByNewUsername != null && !currentUser.getId().equals(userByNewUsername.getId())) {
                throw new UsernameExistException("Username already exists!");
            }
            if (userByNewEmail != null && !currentUser.getId().equals(userByNewEmail.getId())) {
                throw new EmailExistException("Email already exists!");
            }
            return currentUser;
        } else {
            if (userByNewUsername != null) {
                throw new UsernameExistException("Username already exists!");
            }
            if (userByNewEmail != null) {
                throw new EmailExistException("Email already exists!");
            }
            return null;

        }
    }


}
