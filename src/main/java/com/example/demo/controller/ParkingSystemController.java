package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ParkingSpotNotFoundException;
import com.example.demo.model.ParkingSlot;
import com.example.demo.model.Ticket;
import com.example.demo.model.VehicleDAO;
import com.example.demo.service.ParkingSystem;


@RestController
public class ParkingSystemController {
	
	private ParkingSystem service;
	
	public ParkingSystemController(ParkingSystem service) {
		this.service = service;
	}
	
	@GetMapping("/spots/{type}")
	public List<ParkingSlot> getAvailableSpots(@PathVariable String type) throws ParkingSpotNotFoundException{
		return service.getAvailableSpots(type);
	}
	
	@PostMapping("/book/{parkingId}")
	public Ticket bookAvailableSpot(
			@PathVariable Long parkingId,
			@RequestBody VehicleDAO vehicle
			) throws ParkingSpotNotFoundException {
		return service.getTicket(parkingId, vehicle);
	}
	
	@GetMapping("/ticket/{ticketId}")
	public String amountTobePaid(@PathVariable Long ticketId) {
		return service.amountToBePaid(ticketId);
	}

//	@GetMapping("/book/{parkingId}")
//	public Ticket bookAvailableSpot(@PathVariable Long parkingId) throws ParkingSpotNotFoundException {
//		return service.getTicket(parkingId);
//	}
}
