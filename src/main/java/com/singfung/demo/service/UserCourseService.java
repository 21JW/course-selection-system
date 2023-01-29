package com.singfung.demo.service;

import com.singfung.demo.model.dto.UserCourseDTO;

import com.singfung.demo.model.entity.UserCourse;
import com.singfung.demo.repository.UserCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserCourseService {
    private UserCourseRepository userCourseRepository;
    private UserService userService;
    private CourseService courseService;

    @Autowired
    public UserCourseService(UserCourseRepository userCourseRepository, UserService userService, CourseService courseService) {
        this.userCourseRepository = userCourseRepository;
        this.userService = userService;
        this.courseService = courseService;
    }
    public UserCourse addUserCourse(UserCourseDTO dto) {

        Integer userId = dto.getUserId();
        Integer courseId=dto.getCourseId();

        userService.getUserById(userId);
        courseService.getCourseById(courseId);



        UserCourse userCourse = new UserCourse(dto);

        userCourse.setCreateTime(new Date());
        userCourse.setTs(new Date());

        UserCourse responseToController = userCourseRepository.save(userCourse);
        return responseToController;
    }

}
