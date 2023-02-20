package com.singfung.demo.controller;

import com.singfung.demo.model.dto.FlightDTO;
import com.singfung.demo.model.entity.Flight;
import com.singfung.demo.service.FlightService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/flight")
public class FlightController {
    private FlightService flightService;

    public FlightController(FlightService flightService){
        this.flightService=flightService;
    }
    @PostMapping
    public ResponseEntity<?> Register(@RequestBody @Validated(FlightDTO.Insert.class) FlightDTO dto) {
        Flight flight = flightService.addFlight(dto);
        return ResponseEntity.ok(flight);
    }
}