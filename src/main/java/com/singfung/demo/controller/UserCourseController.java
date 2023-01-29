package com.singfung.demo.controller;
import com.singfung.demo.model.dto.UserCourseDTO;
import com.singfung.demo.model.entity.UserCourse;
import com.singfung.demo.service.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usercourse")
public class UserCourseController {
    private UserCourseService userCourseService;
    @Autowired
    public UserCourseController(UserCourseService userCourseService)
    {
        this.userCourseService=userCourseService;
    }

    @PostMapping
    public UserCourse addUserCourse(@RequestBody UserCourseDTO dto) {
        UserCourse responseToPostman = userCourseService.addUserCourse(dto);
        return responseToPostman;
    }
}
