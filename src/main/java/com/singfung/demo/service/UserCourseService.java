package com.singfung.demo.service;

import com.singfung.demo.model.dto.UserCourseDTO;

import com.singfung.demo.model.dto.UserCourseResponse;
import com.singfung.demo.model.entity.Course;
import com.singfung.demo.model.entity.UserCourse;
import com.singfung.demo.model.vo.UserCourseVO;
import com.singfung.demo.repository.CourseRepository;
import com.singfung.demo.repository.UserCourseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class UserCourseService {
    private UserCourseRepository userCourseRepository;
    private UserService userService;
    private CourseService courseService;
    private final CourseRepository courseRepository;

    @Autowired
    public UserCourseService(UserCourseRepository userCourseRepository, UserService userService, CourseService courseService,
                             CourseRepository courseRepository) {
        this.userCourseRepository = userCourseRepository;
        this.userService = userService;
        this.courseService = courseService;
        this.courseRepository = courseRepository;
    }
    public UserCourse addUserCourse(UserCourseDTO dto) {

        Integer userId = dto.getUserId();
        Integer courseId=dto.getCourseId();

        userService.getUserById(userId);
        courseService.getCourseById(courseId);

        UserCourse existingRecord = userCourseRepository.findByUserIdAndCourseId(userId, courseId);
        if(existingRecord != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "You have already chosen this course");
        }

        UserCourse userCourse = new UserCourse(dto);

        userCourse.setCreateTime(new Date());
        userCourse.setTs(new Date());

        UserCourse responseToController = userCourseRepository.save(userCourse);
        return responseToController;
    }

    public List<UserCourseResponse> findAllUserCourseResponse() {
        return userCourseRepository.findAllUserCourseResponse();
    }

    public List<UserCourseVO> findAllUserCourseVO() {
        List<UserCourse> userCourseList = userCourseRepository.findAll();
        List<UserCourseVO> result = new ArrayList<>();
        List<Integer> courseIdList = new ArrayList<>();

        for(UserCourse userCourse : userCourseList) {
            UserCourseVO userCourseVO = new UserCourseVO();
            BeanUtils.copyProperties(userCourse, userCourseVO);
            result.add(userCourseVO);
            courseIdList.add(userCourse.getCourseId());
        }

        List<Course> courseList = courseRepository.findByIdIn(courseIdList);
        Map<Integer, Course> courseMap = new HashMap<>();
        for(Course course : courseList) {
            courseMap.put(course.getId(), course);
        }

        for(UserCourseVO userCourseVO : result) {
            Integer courseId = userCourseVO.getCourseId();
//            userCourseVO.setCourse(courseMap.get(courseId));
        }

        return result;
    }
}
