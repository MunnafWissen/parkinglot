package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.VehicleDAO;
import com.example.demo.repository.VehicleRepo;

@Service
public class VehicleService {
	
	private VehicleRepo repo;
	
	public VehicleService(VehicleRepo repo) {
		this.repo = repo;
	}

	public VehicleDAO getVehicleById(Long id) {
		return repo.findById(id).get();
	}
	public VehicleDAO saveVehicle(VehicleDAO vehicle) {
		return repo.save(vehicle);
	}

}
