package com.singfung.demo.controller;

import com.singfung.demo.model.dto.UserDTO;
import com.singfung.demo.model.entity.User;
import com.singfung.demo.model.enumeration.UserStatus;
import com.singfung.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sing-fung
 * @since 1/22/2023
 */

@RestController
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> Register(@RequestBody @Validated(UserDTO.Insert.class) UserDTO dto) {
        User responseToPostman = userService.addUser(dto);
        return ResponseEntity.ok(responseToPostman);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody @Validated(UserDTO.Update.class) UserDTO dto, @PathVariable Integer id) {
        User responseToPostman = userService.updateUser(dto, id);
        return responseToPostman;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id)
    {
        userService.deleteUserById(id);
    }

    @PutMapping("/{id}/status/{status}")
    public void updateUserStatus(@PathVariable Integer id, @PathVariable UserStatus status) {
        userService.updateUserStatus(id, status);
    }

    @GetMapping("/status/{status}")
    public List<User> getUserByUserStatus(@PathVariable UserStatus status) {
        return userService.findByUserStatus(status);
    }

    @GetMapping("/username/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }
}
