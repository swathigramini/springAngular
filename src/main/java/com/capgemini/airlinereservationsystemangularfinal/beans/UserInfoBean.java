package com.capgemini.airlinereservationsystemangularfinal.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user_info")
public class UserInfoBean {
	
	@Id
	@Column
	@GeneratedValue
	private int userId;
	
	@Column(length = 20)
	private String username;
	
	@Column
	private String userRole;
	
	@Column(unique = true)
	private String emailId;
	
	@Column
	private String password;
	
	@Column(length=10)
	private long mobile;
}
