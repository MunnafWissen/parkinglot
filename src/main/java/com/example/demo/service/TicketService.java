package com.example.demo.service;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.model.ParkingSlot;
import com.example.demo.model.Ticket;
import com.example.demo.repository.TicketRepo;

import jakarta.transaction.Transactional;


@Service
public class TicketService {
	
	private TicketRepo repo;
	private ParkingSystem psService;
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TicketService.class);
	
	public TicketService(TicketRepo repo, ParkingSystem psService) {
		this.repo = repo;
		this.psService = psService;
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

	public List<Ticket> getAllTickets() {
		logger.info("tickets are returned to front end");
		// TODO Auto-generated method stub
		List<Ticket> list = repo.findAll();
		if(list.isEmpty()) {
			logger.info("no tickets are present in db");
		}
		logger.info("no of tickets are"+list.size());
		return list;
	}

	public Ticket saveTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return new Ticket();
	}

	@Transactional
	public void deleteTicketById(Long id) {
		boolean exists = repo.existsById(id);
		if(!exists) {
			logger.warn("ticket is not available in db");
			return;
		}
		Long parkingId = repo.findById(id).get().getParkingId();
		 repo.deleteById(id);
		 
		 psService.setparkingSlotAvailableById(parkingId);
		 
		 
	}
	

}
