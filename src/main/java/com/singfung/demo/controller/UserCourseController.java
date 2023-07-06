package com.singfung.demo.controller;
import com.singfung.demo.model.dto.UserCourseDTO;
import com.singfung.demo.model.dto.UserCourseResponse;
import com.singfung.demo.model.entity.UserCourse;
import com.singfung.demo.model.vo.UserCourseVO;
import com.singfung.demo.service.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<UserCourseResponse> getAllUserCourseResponse() {
        return userCourseService.findAllUserCourseResponse();
    }

    @GetMapping("/v2")
    public List<UserCourseVO> getAllUserCourseVO() {
        return userCourseService.findAllUserCourseVO();
    }
}
