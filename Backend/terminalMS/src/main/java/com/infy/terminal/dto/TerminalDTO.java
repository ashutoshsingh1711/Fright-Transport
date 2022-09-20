package com.infy.terminal.dto;

import com.infy.terminal.entity.ftr_terminals;

public class TerminalDTO {

	private String terminal_id;
	private String name;
	private String country;
	private String item_type;
	private String terminal_description;
	private int capacity;
	private int available_capacity;
	private String status;
	private String harbor_location;

	public TerminalDTO() {
		super();
	}

	public TerminalDTO(String terminal_id,String name, String country, String item_type, String terminal_description, int capacity,
			int available_capacity, String status, String harborLocation) {

		this.setTerminal_id(terminal_id);
		this.name = name;
		this.country = country;
		this.item_type = item_type;
		this.terminal_description = terminal_description;
		this.capacity = capacity;
		this.available_capacity = available_capacity;
		this.status = status;
		this.harbor_location = harborLocation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getTerminal_id() {
		return terminal_id;
	}

	public void setTerminal_id(String terminal_id) {
		this.terminal_id = terminal_id;
	}
	
	public static ftr_terminals prepareToEntity(TerminalDTO dto) {
		ftr_terminals entity = new ftr_terminals();
		entity.setTerminal_id(dto.getTerminal_id());
		entity.setName(dto.getName());
		entity.setCountry(dto.getCountry());
		entity.setItem_type(dto.getItem_type());
		entity.setTerminal_description(dto.getTerminal_description());
		entity.setCapacity(dto.getCapacity());
		entity.setStatus(dto.getStatus());
		entity.setHarborLocation(dto.getHarborLocation());
		entity.setAvailable_capacity(dto.getAvailable_capacity());
		
		return entity;

}
}
