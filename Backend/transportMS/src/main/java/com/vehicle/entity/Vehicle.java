package com.vehicle.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ftr_vehicles")
public class Vehicle {

	@Id
	@Column(name="vehicle_number")
	private String vehicleNumber;
	
	@Column(name="max_lifting_capacity")
	private double maxLifitingCapacity;
	@Column(name="retire_date")
	private Date retireDate;
	@Column(name="vehicle_status")
	private String vehicleStatus;
	@Column(name="country")
	private String country;
	@Column(name="harborLocation")
	private String harborLocation;
	@Column(name="vehicle_name")
	private String vehicleName;
	
	
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
		return "vehicleDetails [vehicleNumber=" + vehicleNumber + ", vehicleName=" + vehicleName
				+ ", maxLifitingCapacity=" + maxLifitingCapacity + ", retireDate=" + retireDate + ", vehicleStatus="
				+ vehicleStatus + ", country=" + country + ", harborLocation=" + harborLocation + "]";
	}
	
	
}
