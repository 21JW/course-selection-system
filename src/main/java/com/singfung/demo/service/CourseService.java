package com.singfung.demo.service;

import com.singfung.demo.model.dto.CourseDTO;
import com.singfung.demo.model.entity.Course;
import com.singfung.demo.repository.CourseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.Optional;

@Service
public class CourseService
{
    private CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    public Course addCourse(CourseDTO dto) {
        Course course = new Course(dto);

        course.setCreateTime(new Date());
        course.setTs(new Date());

        Course responseToController = courseRepository.save(course);
        return responseToController;
    }

    public Course getCourseById(Integer id) {
        Optional<Course> courseOptionalToController = courseRepository.findById(id);
        if((courseOptionalToController).isPresent()) {
            return courseOptionalToController.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found");
    }

    public Course updateCourse(CourseDTO dto, Integer id) {
        Course originalCourse = getCourseById(id);

        if(originalCourse == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found");
        }

        BeanUtils.copyProperties(dto, originalCourse);
        originalCourse.setTs(new Date());

        Course responseToController = courseRepository.save(originalCourse);
        return responseToController;
    }

    public void deleteCourseById(Integer id) {
        Optional<Course> courseOptionalToController = courseRepository.findById(id);
        if(!courseOptionalToController.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found");
        }
        courseRepository.deleteById(id);
    }
}
