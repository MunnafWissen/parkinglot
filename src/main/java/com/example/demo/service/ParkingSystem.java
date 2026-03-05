package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.example.demo.CalculateFair;
import com.example.demo.exception.ParkingSpotNotFoundException;
import com.example.demo.model.ParkingSlot;
import com.example.demo.model.Ticket;
import com.example.demo.model.VehicleDAO;
import com.example.demo.repository.ParkingSlotRepo;

import jakarta.transaction.Transactional;


@Service
public class ParkingSystem {
	
	private ParkingSlotRepo psRepo;
	
	private TicketService tkservice;
	private VehicleService vService;
	private CalculateFair cf;
	
	private static final Logger logger = LoggerFactory.getLogger(ParkingSystem.class);
	
	public ParkingSystem(ParkingSlotRepo psRepo, @Lazy TicketService tkservice,VehicleService vService,@Lazy CalculateFair cf) {
		this.psRepo = psRepo;
		this.tkservice = tkservice;
		this.vService = vService;
		this.cf = cf;
	}
	
	public List<ParkingSlot> getAvailableSpots(String vehicleType) throws ParkingSpotNotFoundException{
		
		List<ParkingSlot> list = psRepo.findAllByVehicleTypeAndIsAvailableTrue(vehicleType);
		logger.info("getting the list of available spots for vehicle type "+vehicleType);
		if(list.isEmpty()) {
			logger.info("no parking spots are available");
			throw new ParkingSpotNotFoundException("parking spot is not available");
		}
		return list;
	}
	
	
	@Transactional
	public Ticket getTicket(Long parkingId, VehicleDAO vehicle) throws ParkingSpotNotFoundException {
		boolean exists = psRepo.existsById(parkingId);
		logger.info("in getTicket()");
		if(!exists) {
			throw new ParkingSpotNotFoundException("parking slot is not available");
		}
		ParkingSlot slot = psRepo.findById(parkingId).get();
		if(!slot.isAvailable()) {
			logger.info("parking lot is already booked");
			throw new ParkingSpotNotFoundException("parking slot is not available");
		}
		
		VehicleDAO savedVehicle = vService.saveVehicle(vehicle);
		logger.info("vehicle is saved in DB");
		Ticket ticket = tkservice.generateTicket(slot, savedVehicle.getVehicleId());
		
		logger.info("ticket is generated");
		ParkingSlot bookedSlot = bookParkingSlot(slot);
		if(bookedSlot.isAvailable()) {
			logger.info("slot booking is unsuccessful");
		}
		
		
		return ticket;
		
	}
	
	public ParkingSlot bookParkingSlot(ParkingSlot slot) {
		
		ParkingSlot bookSlot = slot;
		bookSlot.setAvailable(false);
		
		ParkingSlot returnedSlot = psRepo.save(bookSlot);
		logger.info("updated the backend for parking slot");
		
		return returnedSlot;
	}

	public String amountToBePaid(Long ticketId) {
		Long AmountTobePaid = cf.calculatePrice(ticketId);
		return String.valueOf(AmountTobePaid);
	}

}
