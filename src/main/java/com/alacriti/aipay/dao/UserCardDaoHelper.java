package com.alacriti.aipay.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.alacriti.aipay.model.UserCardRegistration;

public class UserCardDaoHelper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserCardRegistration user = new UserCardRegistration();	
		user.setCardId(rs.getInt("card_id"));
		user.setUserId(rs.getInt("user_id"));
		user.setCardNumber(rs.getLong("card_number"));
		user.setCardHolderName(rs.getString("card_holder_name"));
		user.setCardType(rs.getString("card_type"));
		user.setCardExpiryDate(rs.getString("expiry_date"));
		
		return user;
	}

}
