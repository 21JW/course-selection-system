package com.singfung.demo.service;

import com.singfung.demo.model.dto.UserDTO;
import com.singfung.demo.model.entity.User;
import com.singfung.demo.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
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
}
