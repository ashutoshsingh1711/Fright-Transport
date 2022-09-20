package com.vehicle.validator;

import java.util.regex.Matcher;

import java.util.regex.Pattern;

import com.vehicle.dto.VehicleDTO;
import com.vehicle.exception.VehicleException;

public class Validator {
	public Boolean validatorVehicle(VehicleDTO dto) throws VehicleException{
		return isVehicleNameValid(dto.getVehicleName()) || isVehicleStatusValid(dto.getVehicleStatus()) || isVehicleNumberValid(dto.getVehicleNumber());
	}
	
	private Boolean isVehicleNameValid(String name) throws VehicleException{
		return true;
	/*	if(name.equalsIgnoreCase("Two creane") || name.equalsIgnoreCase("FriePlace Crane") || name.equalsIgnoreCase("Double treadwheel Crane") || name.equalsIgnoreCase("Crawler Crane") || name.equalsIgnoreCase("Aerial Crane") || name.equalsIgnoreCase("Deck Crane"))
			return true;
		else
			throw new VehicleException("{vehicleDetails.vehicleName.invalid}");
		
	} */}
	
	public Boolean isVehicleStatusValid(String status) throws VehicleException{
		
		if(status.equals("Active") || status.equals("Retired") || status.equals("InProgress"))
			return true;
		else
			throw new VehicleException("{vehicleDetails.vehicleStatus.invalid}");
	
	}
	
	public Boolean isVehicleNumberValid(String vehicleNumber) throws VehicleException{
		
		Pattern pattern=Pattern.compile("[A-Za-z]{2}[0-9]{}");
		Matcher hasPattern=pattern.matcher(vehicleNumber);
		
		if(hasPattern.find())
		{
			return true;
		}
		
		throw new VehicleException("{vehicleDetails.vehicleStatus.invalid}");
	}
		

}