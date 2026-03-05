package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ParkingSpotNotFoundException;
import com.example.demo.model.ParkingSlot;
import com.example.demo.model.Ticket;
import com.example.demo.model.VehicleDAO;
import com.example.demo.service.ParkingSystem;
import com.example.demo.service.TicketService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class ParkingSystemController {
	
	private ParkingSystem service;
	
	public ParkingSystemController(ParkingSystem service) {
		this.service = service;
	}
	
	@GetMapping("/spots/{type}")
	public List<ParkingSlot> getAvailableSpots(@PathVariable String type) throws ParkingSpotNotFoundException{
		return service.getAvailableSpots(type);
	}
	
	
	@GetMapping("/parking-slots")
	public List<ParkingSlot> getAllParkingSlots(){
		return service.getAllSpots();
	}
	
	@GetMapping("/parking-slots/available")
	public List<ParkingSlot> getAllAvailableSlots(){
		return service.getAllSpotsAvailable();
	}
	
//	@PostMapping("/book/{parkingId}")
	@PostMapping("/parking-slots/{parkingId}")
	public Ticket bookAvailableSpot(
			@PathVariable Long parkingId,
			@RequestBody VehicleDAO vehicle
			) throws ParkingSpotNotFoundException {
		return service.getTicket(parkingId, vehicle);
	}
	
	@GetMapping("/parking-slots/{id}")
	public ParkingSlot getParkingSlotById(@PathVariable Long id) {
		return service.getParkingSlotById(id);
	}
	
	@GetMapping("/ticket/check-out/{ticketId}")
	public String amountTobePaid(@PathVariable Long ticketId) {
		return service.amountToBePaid(ticketId);
	}
	



//	@GetMapping("/book/{parkingId}")
//	public Ticket bookAvailableSpot(@PathVariable Long parkingId) throws ParkingSpotNotFoundException {
//		return service.getTicket(parkingId);
//	}
}
