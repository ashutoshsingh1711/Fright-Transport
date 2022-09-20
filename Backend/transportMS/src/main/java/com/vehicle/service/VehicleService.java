package com.vehicle.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.vehicle.dto.VehicleDTO;
import com.vehicle.entity.Vehicle;
import com.vehicle.exception.VehicleException;
import com.vehicle.repository.VehicleRepository;
import com.vehicle.validator.Validator;


@Service
public class VehicleService {

	
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
		public String insertNewVehicle( VehicleDTO vehicleDTO) throws VehicleException
		{
			Validator validator=new Validator();
			
			if(!validator.validatorVehicle(vehicleDTO))
				throw new ValidationException("general.exception");
			
			Vehicle vehicle = vehicleDTO.createEntity(vehicleDTO);
			vehicleRepository.save(vehicle);
			return "Vehicle Created Successfully";
		}
		
		public List<VehicleDTO> fetchAvailableVehicles(){
			
			List<Vehicle> availabVehicles =vehicleRepository.findByVehicleStatus("Active");
			
			if(availabVehicles.isEmpty())
				throw new ValidationException("VEHICLE_NOT_FOUNS");
			
			List<VehicleDTO> availabVehiclesDTO = new ArrayList<VehicleDTO>();
			
			for(Vehicle vehicle: availabVehicles)
			{
				availabVehiclesDTO.add(VehicleDTO.toDTO(vehicle));
			}
			return availabVehiclesDTO;
		}
		
		
		public String updateVehicleStatus(String vehicleNumber, VehicleDTO dto)throws VehicleException{
			Validator validator = new Validator();
			
			validator.isVehicleStatusValid(dto.getVehicleStatus());
			
			Vehicle vehicle =vehicleRepository.findByVehicleNumber(vehicleNumber);
			
			if(vehicle == null)
				throw new VehicleException("VEHICLE_NOT_FOUND");
			
			if(vehicle.getVehicleStatus().equals(dto.getVehicleStatus()))
				throw new VehicleException("VEHICLE_UPDATE_ALREADY_EXISTS");
			
			vehicle.setVehicleStatus(dto.getVehicleStatus());
			vehicleRepository.save(vehicle);
			
			return "Status of vehicleNumber:" + vehicle.getVehicleNumber() + "updated Successfully";
			
		}
		
		public VehicleDTO fetchVehicleDetailsByVehicleNumber(String vehicleNumber) throws VehicleException{
			Vehicle vehicle = vehicleRepository.findByVehicleNumber(vehicleNumber);
			if(vehicle==null)
			{
			   throw new VehicleException("vehicle not found");
			}
			
			return VehicleDTO.toDTO(vehicle);
		}
		
		public List<VehicleDTO> fetchVehicleDetailsByVehicleName(String vehicleName) throws VehicleException{
			
			List<Vehicle> vehicleList = vehicleRepository.findByVehicleName(vehicleName);
			if(vehicleList.isEmpty())
				throw new ValidationException("VEHICLE_NOT_FOUNS");
			
			List<VehicleDTO> VehiclesDTOList = new ArrayList<VehicleDTO>();
			
			for(Vehicle vehicle: vehicleList)
			{
				VehiclesDTOList.add(VehicleDTO.toDTO(vehicle));
			}
			return VehiclesDTOList;
		}
		
		public String removeVehicle(String vehicleNumber) throws VehicleException{
			Vehicle vehicle = vehicleRepository.findByVehicleNumber(vehicleNumber);
			
			if(vehicle == null)
				return "Invalid Data";
			
			vehicleRepository.delete(vehicle);
			return ("Vehicle details for"+ vehicleNumber +"is deleted sucessfully");
		}
	}
	
	
