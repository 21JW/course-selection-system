package com.singfung.demo.model.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author sing-fung
 * @since 1/22/2023
 */

@Data
public class UserDTO
{
    @NotBlank(message = "username cannot be empty", groups = {Insert.class})
    String username;

    @NotBlank(message = "password cannot be empty", groups = {Insert.class})
    String password;

    @Email(message = "email cannot be empty", groups = {Insert.class})
    String email;

    public interface Update {}

    public interface Insert {}
}
