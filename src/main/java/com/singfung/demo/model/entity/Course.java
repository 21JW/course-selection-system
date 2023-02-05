package com.singfung.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.singfung.demo.model.dto.CourseDTO;
import com.singfung.demo.model.enumeration.CourseStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "course")
@Data
@NoArgsConstructor
public class Course implements IWithPosition{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "position")
    Integer position;

    @Column(name = "name", nullable = false,length = 30)
    String name;

    @Column(name = "create_time", nullable = false, length = 50)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date createTime;

    @Column(name = "ts", nullable = false, length = 50)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date ts;

    @Enumerated(EnumType.STRING)
    CourseStatus status;

    public Course(CourseDTO dto) {
        BeanUtils.copyProperties(dto, this);
    }


}