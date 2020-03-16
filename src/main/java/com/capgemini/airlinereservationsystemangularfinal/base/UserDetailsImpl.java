//package com.capgemini.airlinereservationsystemangularfinal.base;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.capgemini.airlinereservationsystemangularfinal.beans.UserInfoBean;
//
//public class UserDetailsImpl implements UserDetails{
//
//	private UserInfoBean userInfoBean;
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userInfoBean.getUserRole());
//		return Arrays.asList(authority);
//	}
//
//	@Override
//	public String getPassword() {
//		return userInfoBean.getPassword();
//	}
//
//	@Override
//	public String getUsername() {
//		return userInfoBean.getUsername();
//	}
//
//	@Override                                                                                       
//	public boolean isAccountNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return true;
//	}
//
//	public void setUserInfoBean(List<UserInfoBean> getuser) {
//     return;		
//	}
//
//}
