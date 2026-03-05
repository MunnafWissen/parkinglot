package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.ParkingSlot;

public interface ParkingSlotRepo extends JpaRepository<ParkingSlot, Long>{
	
	public List<ParkingSlot> findAllByVehicleTypeAndIsAvailableTrue(String type);
	
	public List<ParkingSlot> findAllByIsAvailableTrue();
	
	@Modifying
	@Query("UPDATE ParkingSlot p set p.isAvailable = true where p.parkingId = :id")
	public void setIsAvailableTrueById(@Param("id") Long id);
	

}
