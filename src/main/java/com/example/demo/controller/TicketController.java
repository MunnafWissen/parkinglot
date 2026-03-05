package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Ticket;
import com.example.demo.service.TicketService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class TicketController {
	
	
	private TicketService tservice;
	
	public TicketController(TicketService tservice) {
		this.tservice = tservice;
	}
	
	
	@DeleteMapping("/tickets/{id}")
	public void deleteTicketById(@PathVariable Long id) {
		 tservice.deleteTicketById(id);
	}
	
	@GetMapping("/tickets")
	public List<Ticket> getAllTickets(){
		return tservice.getAllTickets();
	}
	
	@GetMapping("/tickets/{id}")
	public Ticket getTicketById(@PathVariable Long id) {
		return tservice.getTicketById(id);
	}
	
	@PostMapping("/tickets")
	public Ticket createTicket(
			@RequestBody Ticket ticket
			) {
		return tservice.saveTicket(ticket);
	}

}
