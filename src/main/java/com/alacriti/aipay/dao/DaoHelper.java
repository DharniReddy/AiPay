package com.alacriti.aipay.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.alacriti.aipay.model.UserCardRegistration;
import com.alacriti.aipay.model.UserRegistration;
public class DaoHelper implements RowMapper<UserRegistration>{
	@Override
	public UserRegistration mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserRegistration user = new UserRegistration();	
	
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setEmail(rs.getString("email"));
		user.setMobilenumber(rs.getLong("mobilenumber"));
		user.setDob(rs.getString("dob"));
		user.setUid(rs.getInt("uid"));
		user.setProfilePic(rs.getString("profile_pic"));
		
		return user;
		
	}
/*public class DaoHelper implements RowMapper<UserCardRegistration>{
	@Override
	public UserCardRegistration mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserCardRegistration user = new UserCardRegistration();	
		user.setCard_id(rs.getInt("card_id"));
		user.setUser_id(rs.getInt("user_id"));
		user.setCard_number(rs.getLong("card_number"));
		user.setCard_holder_name(rs.getString("card_holder_name"));
		user.setCard_type(rs.getString("card_type"));
		user.setExpiry_date(rs.getString("expiry_date"));
		
		return user;
		
	}*/

}
