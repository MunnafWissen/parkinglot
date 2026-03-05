package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ParkingSlot;

public interface ParkingSlotRepo extends JpaRepository<ParkingSlot, Long>{
	
	public List<ParkingSlot> findAllByVehicleTypeAndIsAvailableTrue(String type);

}
