package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="parking_slot")
public class ParkingSlot {
	
	@Id
	@Column(name="parking_id")
	private Long parkingId;
	
	@Column(name="vehicle_type")
	private String vehicleType;
	
	@Column(name="is_available")
	private boolean isAvailable;
	
	public ParkingSlot() {
		
	}

	public ParkingSlot(Long parkingId, String vehicleType, boolean isAvailable) {
		super();
		this.parkingId = parkingId;
		this.vehicleType = vehicleType;
		this.isAvailable = isAvailable;
	}

	public Long getParkingId() {
		return parkingId;
	}

	public void setParkingId(Long parkingId) {
		this.parkingId = parkingId;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "ParkingSlot [parkingId=" + parkingId + ", vehicleType=" + vehicleType + ", isAvailable=" + isAvailable
				+ "]";
	}

}
