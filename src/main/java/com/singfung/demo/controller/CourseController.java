package com.singfung.demo.controller;

import com.singfung.demo.model.dto.CourseDTO;
import com.singfung.demo.model.entity.Course;
import com.singfung.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @PostMapping
    public Course addCourse(@RequestBody CourseDTO dto) {
        Course responseToPostman = courseService.addCourse(dto);
        return responseToPostman;
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Integer id) {
        return courseService.getCourseById(id);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@RequestBody CourseDTO dto, @PathVariable Integer id) {
        Course responseToPostman = courseService.updateCourse(dto, id);
        return responseToPostman;
    }


}
