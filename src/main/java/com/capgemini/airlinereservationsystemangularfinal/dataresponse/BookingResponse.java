package com.capgemini.airlinereservationsystemangularfinal.dataresponse;

import java.util.List;

import com.capgemini.airlinereservationsystemangularfinal.dao.BookingDao;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingResponse {

	private int statusCode;
	private String message;
	private String description;
	
	private BookingDao bookingbean;
	private List<BookingDao> bookingList;
}
