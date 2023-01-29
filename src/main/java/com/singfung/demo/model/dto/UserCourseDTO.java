package com.singfung.demo.model.dto;
import lombok.Data;
import javax.validation.constraints.NotBlank;
@Data
public class UserCourseDTO {
    @NotBlank(message = "userid cannot be empty", groups = {Insert.class})
    Integer userId;

    @NotBlank(message = "courseid cannot be empty", groups = {Insert.class})
    Integer courseId;

    public interface Update {}

    public interface Insert {}
}
