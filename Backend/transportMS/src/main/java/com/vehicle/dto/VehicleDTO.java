package com.vehicle.dto;

import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.vehicle.entity.Vehicle;




public class VehicleDTO {

	@NotNull
	private String vehicleNumber;
	@NotNull
	@Size(max=30,message="{vehicle.vehicleName.invalid}")
	private String vehicleName;
	@NotNull
	private double maxLifitingCapacity;
	@NotNull
	private Date retireDate;
	@NotNull
	private String vehicleStatus;
	@NotNull
	@Size(min=5,max=25,message="String must have 5-25 characters")
	private String country;
	@NotNull
	@Size(min=5,max=25,message="String must have 5-25 characters")
	private String harborLocation;
	
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public double getMaxLifitingCapacity() {
		return maxLifitingCapacity;
	}
	public void setMaxLifitingCapacity(double d) {
		this.maxLifitingCapacity = d;
	}
	public Date getRetireDate() {
		return retireDate;
	}
	public void setRetireDate(Date retireDate) {
		this.retireDate = retireDate;
	}
	public String getVehicleStatus() {
		return vehicleStatus;
	}
	public void setVehicleStatus(String vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getHarborLocation() {
		return harborLocation;
	}
	public void setHarborLocation(String harborLocation) {
		this.harborLocation = harborLocation;
	}
	@Override
	public String toString() {
		return "vehicleDto [vehicleNumber=" + vehicleNumber + ", vehicleName=" + vehicleName + ", maxLifitingCapacity="
				+ maxLifitingCapacity + ", retireDate=" + retireDate + ", vehicleStatus=" + vehicleStatus + ", country="
				+ country + ", harborLocation=" + harborLocation + ", getVehicleNumber()=" + getVehicleNumber()
				+ ", getVehicleName()=" + getVehicleName() + ", getMaxLifitingCapacity()=" + getMaxLifitingCapacity()
				+ ", getRetireDate()=" + getRetireDate() + ", getVehicleStatus()=" + getVehicleStatus()
				+ ", getCountry()=" + getCountry() + ", getHarborLocation()=" + getHarborLocation() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	public static VehicleDTO toDTO(Vehicle vehicle )
	{
		VehicleDTO vehicleDTO= new VehicleDTO();
		
		vehicleDTO.setCountry(vehicle.getCountry());
		vehicleDTO.setHarborLocation(vehicle.getHarborLocation());
		vehicleDTO.setRetireDate(vehicle.getRetireDate());
		vehicleDTO.setVehicleName(vehicle.getVehicleName());
		vehicleDTO.setMaxLifitingCapacity(vehicle.getMaxLifitingCapacity());
		vehicleDTO.setVehicleNumber(vehicle.getVehicleNumber());
		vehicleDTO.setVehicleStatus(vehicle.getVehicleStatus());
		return vehicleDTO;
	}
	
	public Vehicle createEntity(VehicleDTO vehicleDTO) {
		Vehicle vehicle= new Vehicle();
		
		vehicle.setCountry(vehicleDTO.getCountry());
		vehicle.setHarborLocation(vehicleDTO.getHarborLocation());
		vehicle.setRetireDate(vehicleDTO.getRetireDate());
		vehicle.setVehicleName(vehicleDTO.getVehicleName());
		vehicle.setMaxLifitingCapacity(vehicleDTO.getMaxLifitingCapacity());
		vehicle.setVehicleNumber(vehicleDTO.getVehicleNumber());
		vehicle.setVehicleStatus(vehicleDTO.getVehicleStatus());
		return vehicle;
	}
	
	
}
