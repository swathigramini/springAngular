package com.capgemini.airlinereservationsystemangularfinal.beans;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "flight_info")
public class FlightBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int flightId;

	@NotNull
	@Size(min=3 , max=25)
	@Column
	private String flightName;

	@NotNull
	@Size(min=3 , max=20)
	@Column
	private String source;

	@NotNull
	@Size(min=3 , max=20)
	@Column
	private String destination;

	@NotNull
	@Size(min=3 , max=20)
	@Column
	private String classType;

	@NotNull
	@Size(min=70 , max=300)
	@Column
	private int totalSeats;

	@NotNull
	@Size(min=3 , max=10)
	@Column
	private double ticketPrice;

	@Column
	private boolean isActive;
	
//	 @OneToMany(cascade = CascadeType.ALL,mappedBy = "flightBean")
//     private List<BookingBean> booking =  new LinkedList<BookingBean>();
}
