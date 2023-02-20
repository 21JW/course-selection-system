package com.singfung.demo.model.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author sing-fung
 * @since 1/24/2023
 */
@Data
public class CourseDTO
{
    @NotBlank(message = "coursename cannot be empty", groups = {Insert.class})
    String coursename;


    @Min(value = 1, message = "position should be greater than 1", groups = {Update.class, Insert.class})
    Integer position;

    public interface Update {}

    public interface Insert {}
}
