package com.vehicle.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vehicle.entity.Vehicle;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String>{
    

	public List<Vehicle> findByVehicleStatus(String vehicleStatus);
	public Vehicle findByVehicleNumber(String vehicleNumber);
	public List<Vehicle> findByVehicleName(String vehicleName);
	
}
