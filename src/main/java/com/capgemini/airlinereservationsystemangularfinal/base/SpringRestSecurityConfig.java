//package com.capgemini.airlinereservationsystemangularfinal.base;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import com.capgemini.airlinereservationsystemangularfinal.filter.UserNamePasswordAuthenticationFilter;
//import com.capgemini.airlinereservationsystemangularfinal.handlers.MyLogoutSuccessHandler;
//
//@Configuration
//@EnableWebSecurity
//public class SpringRestSecurityConfig {
//
//	@Autowired
//	private UserDetailsService userDetailsService;
//	
//	
//	@Autowired
//    private RestAuthenticationEntryPoint authentiationEntryPoint;
//	
//	@Autowired
//	private AuthenticationSuccessHandler authenticationSuccessHandler;
//
//	@Bean
//	public AuthenticationFailureHandler getAuthenticationFailureHandler() {
//		return new SimpleUrlAuthenticationFailureHandler();
//	}
//	
//	@Autowired
//	private MyLogoutSuccessHandler myLogoutSuccessHandler;
//	
//	@Bean
//	public UsernamePasswordAuthenticationFilter getPasswordAuthenticationFilter() throws Exception {
//		UserNamePasswordAuthenticationFilter filter = new UserNamePasswordAuthenticationFilter();
//		filter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
//		filter.setAuthenticationFailureHandler(getAuthenticationFailureHandler());
//		filter.setAuthenticationManager(authenticationManager());
//		
//		return filter;
//		
//	}
//	
//	private AuthenticationManager authenticationManager() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	protected void configure(AuthenticationManagerBuilder register) throws Exception {
//		register.userDetailsService(userDetailsService);
//	}
//	protected void configure(HttpSecurity http) throws Exception {
//         http.csrf().disable()
//         .exceptionHandling()
//         .authenticationEntryPoint(authentiationEntryPoint)
//         .and()
//         .authorizeRequests()
//         .antMatchers("/getuser").hasRole("USER")
//         .and()
//         .authorizeRequests()
//         .antMatchers("/getAllUsers").hasRole("ADMIN")
//         .and()
//         .authorizeRequests()
//         .antMatchers("/register").permitAll()
//         .and()
//         .addFilterBefore(getPasswordAuthenticationFilter(),UserNamePasswordAuthenticationFilter.class)
//         .logout()
//         .logoutSuccessHandler(myLogoutSuccessHandler);
//         
//	}
//
//}
