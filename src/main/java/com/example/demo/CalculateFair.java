package com.example.demo;

import java.time.Duration;
import java.time.LocalTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.example.demo.model.Ticket;
import com.example.demo.model.Vehicle;
import com.example.demo.model.VehicleFactory;
import com.example.demo.service.TicketService;

@Configuration
public class CalculateFair {
	
	@Lazy
	private TicketService tservice;
	
	public CalculateFair( TicketService tservice) {
		this.tservice = tservice;
	}

	public Long calculatePrice(Long ticketId) {
		Ticket ticket = tservice.getTicketById(ticketId);
		Long fair =0L;
		LocalTime ctime = ticket.getCreationTime();
		LocalTime etime = LocalTime.now();
		
		Vehicle currentVehicle = VehicleFactory.getVehicle(ticket.getVehicleType());
		
		int baseFair = currentVehicle.getBaseFair();
		System.out.println("vehicleType is "+ticket.getVehicleType());
		System.out.println("base fair is "+ baseFair);
		
		long hours = Duration.between(ctime, etime).toHours();
		
		fair = baseFair + (hours* 20);
		
		System.out.println("the base fair is "+fair);
		
		return fair;
	}

}
