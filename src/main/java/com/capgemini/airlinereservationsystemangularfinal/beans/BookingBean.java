package com.capgemini.airlinereservationsystemangularfinal.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "booking_flight")
public class BookingBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int bookingId;

	@Column
	private int userId;

	@Column
	private int flightId;


	@Column(nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date journeyDate;

	@Column(length = 20)
	private String source;

	@Column(length = 20)
	private String destination;

	@Min(70)
	@Max(100)
	@Column
	private int numOfSeats;

//	@Column
//	private Date bookingDate;

//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "userId", referencedColumnName = "userId", insertable = false, updatable = false)
//	private UserInfoBean user;
//
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "flightId", referencedColumnName = "flightId", insertable = false, updatable = false)
//	private FlightBean flightBean;
}