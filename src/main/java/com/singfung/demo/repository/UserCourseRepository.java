package com.singfung.demo.repository;


import com.singfung.demo.model.entity.UserCourse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface UserCourseRepository extends JpaRepository<UserCourse, Serializable> {

}
