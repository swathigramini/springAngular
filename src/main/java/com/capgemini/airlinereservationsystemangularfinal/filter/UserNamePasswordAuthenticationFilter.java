/*
 * package com.capgemini.airlinereservationsystemangularfinal.filter;
 * 
 * import java.io.BufferedReader; import java.io.IOException;
 * 
 * import javax.servlet.http.HttpServletRequest;
 * 
 * import org.springframework.http.MediaType; import
 * org.springframework.security.web.authentication.
 * UsernamePasswordAuthenticationFilter; import
 * org.springframework.stereotype.Component;
 * 
 * import com.capgemini.airlinereservationsystemangularfinal.beans.UserInfoBean;
 * import com.fasterxml.jackson.databind.ObjectMapper;
 * 
 * @Component public class UserNamePasswordAuthenticationFilter extends
 * UsernamePasswordAuthenticationFilter{
 * 
 * private UserInfoBean userInfoBean;
 * 
 * @Override protected String obtainUsername(HttpServletRequest request) { if
 * (request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {
 * userInfoBean = null; try { UserInfoBean infoBean = getUserInfo(request);
 * return infoBean.getUsername(); } catch (IOException e) { // TODO
 * Auto-generated catch block e.printStackTrace(); return ""; } } return
 * super.obtainUsername(request); }
 * 
 * @Override protected String obtainPassword(HttpServletRequest request) {
 * if(request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) { try {
 * UserInfoBean infoBean = getUserInfo(request); return infoBean.getPassword();
 * } catch (IOException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); return ""; } } return super.obtainPassword(request); }
 * 
 * private UserInfoBean getUserInfo(HttpServletRequest request) throws
 * IOException { if (userInfoBean == null) { ObjectMapper mapper = new
 * ObjectMapper(); String json = ""; BufferedReader reader =
 * request.getReader(); while (reader.ready()) { json = json +
 * reader.readLine(); } userInfoBean = mapper.readValue(json,
 * UserInfoBean.class); } return userInfoBean; } }
 */