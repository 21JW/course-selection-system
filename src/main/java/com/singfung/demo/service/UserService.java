package com.singfung.demo.service;

import com.singfung.demo.model.dto.UserDTO;
import com.singfung.demo.model.entity.User;
import com.singfung.demo.model.enumeration.UserStatus;
import com.singfung.demo.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author sing-fung
 * @since 1/22/2023
 */

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(UserDTO dto) {
        User user = new User(dto);

        user.setCreateTime(new Date());
        user.setTs(new Date());

        User responseToController = userRepository.save(user);
        return responseToController;
    }

    public User getUserById(Integer id) {
        Optional<User> userOptionalToController = userRepository.findById(id);
        if(userOptionalToController.isPresent()) {
            return userOptionalToController.get();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
    }

    public User updateUser(UserDTO dto, Integer id) {
        User originalUser = getUserById(id);

        if(originalUser == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        BeanUtils.copyProperties(dto, originalUser);
        originalUser.setTs(new Date());

        User responseToController = userRepository.save(originalUser);
        return responseToController;
    }

    public void deleteUserById(Integer id) {
        Optional<User> userOptionalToController = userRepository.findById(id);
        if(!userOptionalToController.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        userRepository.deleteById(id);
    }

    public void updateUserStatus(Integer id, UserStatus status) {
        User user = getUserById(id);

        if(status == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "UserStatus could not be null");
        }

        user.setStatus(status);

        userRepository.save(user);
    }

    public List<User> findByUserStatus(UserStatus status) {
        List<User> response = userRepository.findByStatus(status);

        return response;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
