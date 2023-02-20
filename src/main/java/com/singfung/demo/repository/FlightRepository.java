package com.singfung.demo.repository;

import com.singfung.demo.model.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Serializable> {

}