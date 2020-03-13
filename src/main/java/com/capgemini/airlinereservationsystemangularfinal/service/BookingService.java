package com.capgemini.airlinereservationsystemangularfinal.service;

import java.util.List;

import com.capgemini.airlinereservationsystemangularfinal.beans.BookingBean;

public interface BookingService {
	public boolean booking(BookingBean booking);
	public List<BookingBean> getticket();
}
