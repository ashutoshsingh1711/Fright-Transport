package com.infy.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.infy.dto.UserDTO;
@Entity
@Table(name="ftr_user")
public class UserEntity {

	public UserEntity(int user_id, String first_name, String last_name, String email_id
			, String password,
			long mobile_number, String nationality, String passport_number, String permanent_address,
			String office_address, long personal_identification_number) {
		super();
		
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email_id = email_id;
		this.password = password;
		this.mobile_number = mobile_number;
		this.nationality = nationality;
		this.passport_number = passport_number;
		this.permanent_address = permanent_address;
		this.office_address = office_address;
		this.personal_identification_number = personal_identification_number;
	}




	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;
	private String first_name;
	private String last_name;
	private String email_id;
	private String password;
	private long mobile_number;
	private String nationality;
	private String passport_number;
	private String permanent_address;
	private String office_address;
	private long personal_identification_number;
	
	
	
	
	public static UserDTO preapreUserDTO(UserEntity u) {
		UserDTO ut=new UserDTO();
		ut.setUser_id(u.getUser_id());		
		ut.setFirst_name(u.getFirst_name());
		ut.setLast_name(u.getLast_name());
		ut.setEmail_id(u.getEmail_id());
		ut.setMobile_number(u.getMobile_number());
		ut.setPassword(u.getPassword());
		ut.setNationality(u.getNationality());
		ut.setPassport_number(u.getPassport_number());
		ut.setPermanent_address(u.getPermanent_address());
		ut.setOffice_address(u.getOffice_address());
		ut.setPersonal_identification_number(u.getPersonal_identification_number());
		return ut;
		
	}




	public int getUser_id() {
		return user_id;
	}




	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}




	public String getFirst_name() {
		return first_name;
	}




	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}




	public String getLast_name() {
		return last_name;
	}




	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}




	public String getEmail_id() {
		return email_id;
	}




	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public long getMobile_number() {
		return mobile_number;
	}




	public void setMobile_number(long mobile_number) {
		this.mobile_number = mobile_number;
	}




	public String getNationality() {
		return nationality;
	}




	public void setNationality(String nationality) {
		this.nationality = nationality;
	}




	public String getPassport_number() {
		return passport_number;
	}




	public void setPassport_number(String passport_number) {
		this.passport_number = passport_number;
	}




	public String getPermanent_address() {
		return permanent_address;
	}




	public void setPermanent_address(String permanent_address) {
		this.permanent_address = permanent_address;
	}




	public String getOffice_address() {
		return office_address;
	}




	public void setOffice_address(String office_address) {
		this.office_address = office_address;
	}




	public long getPersonal_identification_number() {
		return personal_identification_number;
	}




	public void setPersonal_identification_number(long personal_identification_number) {
		this.personal_identification_number = personal_identification_number;
	}
	
	
	
}
