package com.capgemini.airlinereservationsystemangularfinal.beans;

import java.security.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "booking_flight")
public class BookingBean {

	@Id
	@Column(length = 3)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	
	@Column(length = 3)
	private int userId;
	
	@Column
	private int f_id;

	@Column
	private Date journeyDate;
	
	@Column(length = 20)
	private String source;

	@Column(length = 20)
	private String destination;

	@Column
	private int numOfSeats;
	
	@Column
	private Timestamp bookingDateTime;
	
	@OneToOne
	@JoinColumn(name="userId")
	private UserInfoBean userInfoBean;
	
	@OneToOne
	@JoinColumn(name="f_id")
	private FlightBean flightBean;
}