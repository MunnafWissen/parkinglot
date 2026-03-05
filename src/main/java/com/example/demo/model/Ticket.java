package com.example.demo.model;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ticketId;
	
	private Long parkingId;
	
	private LocalTime creationTime;
	
	private String vehicleType;
	
	private Long vehicleId;
	
	
	public Ticket() {
		
	}

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public Long getParkingId() {
		return parkingId;
	}

	public void setParkingId(Long parkingId) {
		this.parkingId = parkingId;
	}

	public LocalTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(LocalTime creationTime) {
		this.creationTime = creationTime;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Ticket(Long parkingId, Long vehicleId, String vehicleType) {
		super();
		this.parkingId = parkingId;
		this.creationTime = LocalTime.now();
		this.vehicleType = vehicleType;
		this.vehicleId = vehicleId;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", parkingId=" + parkingId + ", creationTime=" + creationTime
				+ ", vehicleType=" + vehicleType + ", vehicleId=" + vehicleId +"]";
	}

}
