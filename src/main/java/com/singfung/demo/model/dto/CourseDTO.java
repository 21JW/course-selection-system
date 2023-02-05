package com.singfung.demo.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author sing-fung
 * @since 1/24/2023
 */
@Data
public class CourseDTO
{
    @NotBlank(message = "name cannot be empty", groups = {Insert.class})
    String name;

    @NotBlank(message = "position cannot be empty", groups = {Insert.class})
    Integer position;

    public interface Update {}

    public interface Insert {}
}
