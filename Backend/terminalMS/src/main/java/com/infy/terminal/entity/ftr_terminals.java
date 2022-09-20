package com.infy.terminal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.infy.terminal.dto.TerminalDTO;

@Entity
public class ftr_terminals {  
	
	@Id
	private String terminal_id;
	@Size(max=20, min=3, message="Terminal Name should be minimum of 3 characters and maximum of 20 characters.")
	private String terminal_name;

	@Size(max=20, min=3, message="Country Name should be minimum of 3 characters and maximum of 20 characters.")
	private String country;
	
	@Size(max=30, min=4, message="Item type should be minimum of 4 characters and maxiumum of 30 characters.")
	private String item_type;
	
	@Size(max=25 ,message="Terminal Description should be maximum of 25 characters.")
	private String terminal_description;
	
	@Max(value = 99999, message= "Terminal Capacity is maximum of size 9999.")
	private Integer capacity;
	
	@Pattern(regexp="^(Available|NotAvailable)$", message="Terminal Status should be either \'Available\' or \'Not Available\'.")   
	private String status;
	
	private String  harbor_location;
	
	@Max(value = 99999, message="Terminal AvailableCapacity is maximum of size 99999.")
	private Integer available_capacity;
	public ftr_terminals() {
		super();
	}
	public ftr_terminals(String terminal_id, String name, String country, String item_type, String terminal_description,
			int capacity, int available_capacity, String status, String harborLocation) {
		super();
		this.terminal_id = terminal_id;
		this.terminal_name = name;
		this.country = country;
		this.item_type = item_type;
		this.terminal_description = terminal_description;
		this.capacity = capacity;
		this.available_capacity = available_capacity;
		this.status = status;
		this.harbor_location = harborLocation;
	}
	public String getTerminal_id() {
		return terminal_id;
	}
	public void setTerminal_id(String terminal_id) {
		this.terminal_id = terminal_id;
	}
	public String getName() {
		return terminal_name;
	}
	public void setName(String name) {
		this.terminal_name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getItem_type() {
		return item_type;
	}
	public void setItem_type(String item_type) {
		this.item_type = item_type;
	}
	public String getTerminal_description() {
		return terminal_description;
	}
	public void setTerminal_description(String terminal_description) {
		this.terminal_description = terminal_description;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getAvailable_capacity() {
		return available_capacity;
	}
	public void setAvailable_capacity(int available_capacity) {
		this.available_capacity = available_capacity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getHarborLocation() {
		return harbor_location;
	}
	public void setHarborLocation(String harborLocation) {
		this.harbor_location = harborLocation;
	}
	
	public static TerminalDTO prepareToDto(ftr_terminals entity) {
		
		 TerminalDTO dto = new TerminalDTO();
		 dto.setTerminal_id(entity.getTerminal_id());
		 dto.setName(entity.getName());
		 dto.setCountry(entity.getCountry());
		 dto.setItem_type(entity.getItem_type());
		 dto.setTerminal_description(entity.getTerminal_description());
		 dto.setCapacity(entity.getCapacity());
		 dto.setStatus(entity.getStatus());
		 dto.setHarborLocation(entity.getHarborLocation());
		 dto.setAvailable_capacity(entity.getAvailable_capacity());
			
			return dto;
		}
		
	
	

}
