//package com.capgemini.airlinereservationsystemangularfinal.base;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import com.capgemini.airlinereservationsystemangularfinal.dao.UserDao;
//
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//	@Autowired
//	private UserDao dao;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		UserDetailsImpl userDetailsImpl = new UserDetailsImpl();
//		userDetailsImpl.setUserInfoBean(dao.getuser(username));
//		return userDetailsImpl;
//	}
//}
