package com.example.demo.model;

public class VehicleFactory {
	
	public static Vehicle getVehicle(String type) {
		if(type.equalsIgnoreCase("FourWheelers")) return new FourWheelers();
		else if(type.equalsIgnoreCase("disabled")) return new Disabled();
		return new TwoWheelers();
			
	}

}
