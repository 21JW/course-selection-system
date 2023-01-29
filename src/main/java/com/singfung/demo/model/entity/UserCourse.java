package com.singfung.demo.model.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.singfung.demo.model.dto.UserCourseDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_course")
@Data
@NoArgsConstructor
public class UserCourse {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "userId")
    Integer userId;

    @Column(name = "courseId")
    Integer courseId;

    @Column(name = "create_time", nullable = false, length = 50)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date createTime;

    @Column(name = "ts", nullable = false, length = 50)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date ts;

    public UserCourse(UserCourseDTO dto) {
        BeanUtils.copyProperties(dto, this);
    }
}
