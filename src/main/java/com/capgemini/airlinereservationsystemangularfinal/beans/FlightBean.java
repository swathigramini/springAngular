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
@Table(name = "flight_info")
public class FlightBean {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int f_id;

	@Column
	private String flightName;

	@Column(length = 20)
	private String source;

	@Column(length = 20)
	private String destination;

	@Column
	private String classType;

	@Column
	private int totalSeats;

	@Column
	private double ticketPrice;

	@Column
	private boolean isActive;
}
