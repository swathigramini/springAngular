package com.capgemini.airlinereservationsystemangularfinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.capgemini.airlinereservationsystemangularfinal.beans.UserInfoBean;
import com.capgemini.airlinereservationsystemangularfinal.dao.UserDaoImpl;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDaoImpl dao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public boolean register(UserInfoBean userInfoBean) {
		userInfoBean.setPassword(passwordEncoder.encode(userInfoBean.getPassword()));
		return dao.register(userInfoBean);
	}

	@Override
	public boolean updateUser(UserInfoBean bean) {
		return dao.updateUser(bean);
	}

	@Override
	public List<UserInfoBean> getAllUsers() {
		return dao.getAllUsers();
	}

	@Override
	public List<UserInfoBean> getuser(String username) {
		return dao.getuser(username);
	}	
}
