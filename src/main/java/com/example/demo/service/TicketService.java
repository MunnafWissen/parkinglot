package com.example.demo.service;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.model.ParkingSlot;
import com.example.demo.model.Ticket;
import com.example.demo.model.VehicleFactory;
import com.example.demo.repository.TicketRepo;


@Service
public class TicketService {
	
	private TicketRepo repo;
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TicketService.class);
	
	public TicketService(TicketRepo repo) {
		this.repo = repo;
	}
	
	public Ticket getTicketById(Long ticketId) {
		boolean exists = repo.existsById(ticketId);
		if(!exists) {
			logger.warn("ticket id is not found");
			return new Ticket();
		}
		return repo.findById(ticketId).get();
		
	}
	
	public Ticket generateTicket(ParkingSlot slot, Long id) {
		
		
		Ticket ticket = new Ticket(
				slot.getParkingId(),
				id,
				slot.getVehicleType()
				
				);

		repo.save(ticket);
		return ticket;
	}
	

}
