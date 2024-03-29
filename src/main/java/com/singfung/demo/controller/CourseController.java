package com.singfung.demo.controller;

import com.singfung.demo.model.dto.CourseDTO;
import com.singfung.demo.model.dto.SetPositionRequest;
import com.singfung.demo.model.entity.Course;
import com.singfung.demo.model.enumeration.CourseStatus;
import com.singfung.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        courseService.deleteCourseById(id);
    }

    @PutMapping("/{id}/status/{status}")
    public void updateCourseStatus(@PathVariable Integer id, @PathVariable CourseStatus status) {
        courseService.updateCourseStatus(id, status);
    }

    @GetMapping("/status/{status}")
    public List<Course> getCourseByCourseStatus(@PathVariable CourseStatus status) {
        return courseService.findByCourseStatus(status);
    }

    @GetMapping
    public List<Course> getAllCourse() {
        return courseService.getAllCourse();
    }

    @GetMapping("/ts")
    public List<Course> getCourseByTs() {
        return courseService.getCourseByTs();
    }

    @GetMapping("/ts/{startDate}/{endDate}")
    public List<Course> getCourseByTsBetween(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return courseService.getCourseByTsBetween(startDate, endDate);
    }

    @GetMapping("/position")
    public List<Course> getListByPosition(@RequestBody SetPositionRequest data) {
        return courseService.setPosition(data);
    }

    @GetMapping("/coursename/{coursename}")
    public Course getCourseByCoursename(@PathVariable String coursename)
    {
        return courseService.findByCoursename(coursename);
    }
}


