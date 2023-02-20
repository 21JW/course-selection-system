package com.singfung.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.singfung.demo.model.dto.FlightDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "flight")
@Data
@NoArgsConstructor
public class Flight {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Company", nullable = false, length = 256)
    private String company;

    @Column(name = "Flightname", nullable = false, length = 256)
    private String flightname;

    @Column(name = "Departure", nullable = false, length = 256)
    private String departure;

    @Column(name = "Destination", nullable = false, length = 256)
    private String destination;

    @Column(name = "create_time", nullable = false, length = 50)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @Column(name = "ts", nullable = false, length = 50)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ts;

    @Column(name = "price")
    private Integer price;

    @Column(name = "departTime")
    private Date departTime;

    public Flight(FlightDTO dto) {
        BeanUtils.copyProperties(dto, this);
    }

}
