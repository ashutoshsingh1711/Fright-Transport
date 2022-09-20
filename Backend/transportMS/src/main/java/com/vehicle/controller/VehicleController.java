package com.vehicle.controller;

import java.util.List;


import javax.validation.Valid;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.vehicle.dto.VehicleDTO;
import com.vehicle.exception.VehicleException;
import com.vehicle.service.VehicleService;


@RestController
@RequestMapping("/ftr/vehicles")
public class VehicleController {

		@Autowired
		private VehicleService vehicleService;
		
		@CrossOrigin(origins="*",allowedHeaders="*")
		@PostMapping
		public ResponseEntity<String> insertNewVehicle(@Valid @RequestBody VehicleDTO dto) throws VehicleException{
			
			return new ResponseEntity<String>(vehicleService.insertNewVehicle(dto) , HttpStatus.OK);
		}
		
		@CrossOrigin(origins="*",allowedHeaders="*")
		@GetMapping
		public ResponseEntity<List<VehicleDTO>> fetchAvailableVehicles(){
			
			return new ResponseEntity<List<VehicleDTO>>(vehicleService.fetchAvailableVehicles(),HttpStatus.OK);
		}
		
		@PutMapping(value="/{vehicleNumber}")
		public ResponseEntity<String> updateVehicleStatus(@PathVariable String vehicleNumber,@RequestBody VehicleDTO dto) throws VehicleException
		{
			return new ResponseEntity<String>(vehicleService.updateVehicleStatus(vehicleNumber,dto),HttpStatus.OK);
		}
		
		@GetMapping("/vehicleNumber/{vehicleNumber}")
		public ResponseEntity<VehicleDTO> fetchVehicleDetailsByVehicleNumber(@PathVariable("vehicleNumber") String vehicleNumber ) throws VehicleException{
			return new ResponseEntity<VehicleDTO>(vehicleService.fetchVehicleDetailsByVehicleNumber(vehicleNumber),HttpStatus.OK);
		}
		
		@GetMapping("/vehicleName/{vehicleName}")
		public ResponseEntity<List<VehicleDTO>> fetchVehicleDetailsByVehicleName(@PathVariable("vehicleName") String vehicleName ) throws VehicleException{
			return new ResponseEntity<List<VehicleDTO>>(vehicleService.fetchVehicleDetailsByVehicleName(vehicleName),HttpStatus.OK);
		}
		
		@DeleteMapping("/{vehicleNumber}")
		public ResponseEntity<String> removeVehicle(@PathVariable String vehicleNumber)throws VehicleException{
			return new ResponseEntity<String>(vehicleService.removeVehicle(vehicleNumber),HttpStatus.OK);
		}
}
