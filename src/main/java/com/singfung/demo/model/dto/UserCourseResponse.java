package com.singfung.demo.model.dto;

import com.singfung.demo.model.entity.Course;
import com.singfung.demo.model.entity.User;
import com.singfung.demo.model.entity.UserCourse;
import lombok.Data;

@Data
public class UserCourseResponse {
    Integer id;
    String username;
    String courseName;

    public UserCourseResponse(UserCourse userCourse, User user, Course course) {
        this.id = userCourse.getId();
        this.username = user.getUsername();
        this.courseName = course.getName();
    }
}
