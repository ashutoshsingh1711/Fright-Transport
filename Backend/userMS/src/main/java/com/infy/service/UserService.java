package com.infy.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.UserDTO;
import com.infy.entity.UserEntity;
import com.infy.exception.UserNotFoundException;
import com.infy.repository.UserRepository;

@Service
@Transactional
public class UserService {
	@Autowired
	UserRepository userRepository;

	public UserEntity insert(UserDTO dto) {
		// TODO Auto-generated method stub
		return userRepository.saveAndFlush(UserDTO.preapreUserEntity(dto));
	}

	public UserDTO getUser(int id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		
		UserEntity u= (userRepository.getuser(id));
		if(u!=null) {
			return UserEntity.preapreUserDTO(u);
		}
		else {
			throw new UserNotFoundException("user details not found ");
		}
	}
	
	public void updateUser(int id, UserDTO dto) {
		UserEntity u= userRepository.getuser(id);
		if(dto.getFirst_name()!=null)
		u.setFirst_name(dto.getFirst_name());
		
		
		if(dto.getLast_name()!=null)
		u.setLast_name(dto.getLast_name());
		
		
		if(dto.getEmail_id()!=null)
		u.setEmail_id(dto.getEmail_id());
		
		
		if(dto.getMobile_number()!=0)
		u.setMobile_number(dto.getMobile_number());
		
		if(dto.getNationality()!=null)
		u.setNationality(dto.getNationality());
		
		if(dto.getPassport_number()!=null)
		u.setPassport_number(dto.getPassport_number());
		
		if(dto.getPermanent_address()!=null)
		u.setPermanent_address(dto.getPermanent_address());
		
		
		if(dto.getPermanent_address()!=null)
		u.setOffice_address(dto.getOffice_address());
		userRepository.save(u);
	}

	public void getUserById(long l) throws UserNotFoundException {
		// TODO Auto-generated method stub
		UserEntity u= (userRepository.getuserById(l));
		if(u!=null) {
			throw new UserNotFoundException("user already present ");
		}
	}
	
}
