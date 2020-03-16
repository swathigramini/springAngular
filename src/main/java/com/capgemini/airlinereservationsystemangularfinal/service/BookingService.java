package com.capgemini.airlinereservationsystemangularfinal.service;

import java.util.List;

import com.capgemini.airlinereservationsystemangularfinal.beans.BookingBean;
import com.capgemini.airlinereservationsystemangularfinal.beans.UserInfoBean;

public interface BookingService {
	
	public boolean bookingFlights(BookingBean booking);

	public List<BookingBean> getTicket(int bookingId);

	public boolean deleteTicket(int bookingId);
}
