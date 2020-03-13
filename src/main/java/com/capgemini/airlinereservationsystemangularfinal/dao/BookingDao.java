package com.capgemini.airlinereservationsystemangularfinal.dao;

import java.util.List;

import com.capgemini.airlinereservationsystemangularfinal.beans.BookingBean;

public interface BookingDao {

	public boolean booking(BookingBean booking);
	
	public List<BookingBean> getticket();
}
