package com.capgemini.airlinereservationsystemangularfinal.beans;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "user_info")
public class UserInfoBean {

	@Id
	@Column
	@GeneratedValue
	private int userId;

	@NotNull
	@Column
	@Size(min = 3, max = 30)
	private String userName;

	@NotNull
	@Column
	private String userRole;

	@NotNull
	@Column(unique = true)
	private String emailId;

	@NotNull
	@Column
	@Size(min = 8, max = 20)
	private String password;

	@NotNull
	@Column(length = 10)
	private long mobile;

//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
//	private List<BookingBean> booking = new LinkedList<BookingBean>();
}
