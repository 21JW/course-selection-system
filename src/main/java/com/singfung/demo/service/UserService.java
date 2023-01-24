package com.singfung.demo.service;

import com.singfung.demo.model.dto.UserDTO;
import com.singfung.demo.model.entity.User;
import com.singfung.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
        return null;
    }
}
