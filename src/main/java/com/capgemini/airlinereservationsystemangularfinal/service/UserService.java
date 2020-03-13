package com.capgemini.airlinereservationsystemangularfinal.service;

import java.util.List;

import com.capgemini.airlinereservationsystemangularfinal.beans.UserInfoBean;


public interface UserService {
	public boolean register(UserInfoBean userInfoBean);

	public List<UserInfoBean> getuser(String username);

	public List<UserInfoBean> getAllUsers();

	public boolean updateUser(UserInfoBean bean);
}
