package com.singfung.demo.repository;

import com.singfung.demo.model.entity.Course;
import com.singfung.demo.model.enumeration.CourseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
@Repository
public interface
CourseRepository extends JpaRepository<Course, Serializable> {
    List<Course> findByStatus(CourseStatus status);

    Course findByCoursename(String coursename);

    List<Course> findByOrderByIdDesc();

    List<Course> findByOrderByTsAsc();

    List<Course> findByTsBetween(Date startDate,Date endDate);

    List<Course> findByOrderByPositionAsc();
}
