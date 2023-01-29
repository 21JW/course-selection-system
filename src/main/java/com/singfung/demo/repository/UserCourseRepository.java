package com.singfung.demo.repository;


import com.singfung.demo.model.dto.UserCourseResponse;
import com.singfung.demo.model.entity.UserCourse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface UserCourseRepository extends JpaRepository<UserCourse, Serializable> {
    UserCourse findByUserIdAndAndCourseId(Integer userId, Integer courseId);

    @Query("SELECT new com.singfung.demo.model.dto.UserCourseResponse(uc, u, c) FROM UserCourse uc, User u, Course c WHERE uc.userId = u.id and uc.courseId = c.id order by uc.id desc ")
    List<UserCourseResponse> findAllUserCourseResponse();
}
