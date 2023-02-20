package com.singfung.demo.service;

import com.singfung.demo.model.dto.FlightDTO;
import com.singfung.demo.model.entity.Flight;
import com.singfung.demo.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FlightService {
    private FlightRepository flightRepository;
    public FlightService(FlightRepository flightRepository)
    {
        this.flightRepository=flightRepository;
    }
    public Flight addFlight(FlightDTO dto) {

        Flight flight = new Flight(dto);

        flight.setCreateTime(new Date());
        flight.setTs(new Date());

        Flight response = flightRepository.save(flight);
        return response;
    }

}
