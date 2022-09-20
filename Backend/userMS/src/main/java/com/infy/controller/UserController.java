package com.infy.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.infy.dto.UserDTO;
import com.infy.entity.UserEntity;
import com.infy.exception.UserNotFoundException;
import com.infy.service.UserService;

@RestController

@CrossOrigin()
public class UserController {

	@Autowired
	UserService service;
	
	@PostMapping("ftr/userProfile")
	public UserEntity addUser(@Valid @RequestBody UserDTO dto) throws UserNotFoundException {
		service.getUserById((dto.getPersonal_identification_number()));
		UserEntity u=service.insert(dto);
		return  u;
	}
	@GetMapping("ftr/userProfile/{id}")
	public UserDTO getUser(@PathVariable int id) throws UserNotFoundException   {
	    return service.getUser(id);
		
	}
	
	
	@PutMapping("ftr/userProfile/{id}")
	
	public String updateUser(@PathVariable int id, @RequestBody UserDTO dto) throws UserNotFoundException {
		if(dto.getMobile_number()==0 || dto.getOffice_address()==null || dto.getPermanent_address()==null )
			throw new UserNotFoundException("Mobile number or permanent address or office address should present");
		service.updateUser(id,dto);
		return "User details are updated successfully";
	}
}
