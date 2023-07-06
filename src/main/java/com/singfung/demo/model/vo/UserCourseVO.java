package com.singfung.demo.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.singfung.demo.model.entity.Course;
import lombok.Data;

@Data
public class UserCourseVO {
    Integer id;
    Course course;
    Integer userId;
    @JsonIgnore
    Integer courseId;
}
