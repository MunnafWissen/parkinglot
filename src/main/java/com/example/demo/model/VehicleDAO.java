package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Vehicle")
public class VehicleDAO {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long VehicleId;
	
	@Column(name="parking_id")
	private Long parkingId;
	
	@Column(name="vehicleNumber")
	private String vehicleNo;
	
	@Column(name="vehicleType")
	private String vehicleType;
	
	@Column(name="basePrice")
	private Integer basePrice;
	
//	@OneToMany
//	private List<Ticket> ticketId;

	public VehicleDAO(Long VehicleId,Long parkingId,String vehicleNo, String vehicleType, Integer basePrice) {
		super();
		this.VehicleId = VehicleId;
		this.parkingId = parkingId;
		this.vehicleNo = vehicleNo;
		this.vehicleType = vehicleType;
		this.basePrice = basePrice;
		
	}
	
	public VehicleDAO() {
		
	}

	public Long getVehicleId() {
		return VehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		VehicleId = vehicleId;
	}

	public Long getParkingId() {
		return parkingId;
	}
	public void setParkingId(Long parkingId) {
		this.parkingId = parkingId;
	}

	@Override
	public String toString() {
		return "VehicleDAO [vehicleNo=" + vehicleNo + ", ParkingID =" + parkingId +", vehicleType=" + vehicleType + ", basePrice=" + basePrice + "]";
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Integer getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Integer basePrice) {
		this.basePrice = basePrice;
	}
	
	
	
	
}
