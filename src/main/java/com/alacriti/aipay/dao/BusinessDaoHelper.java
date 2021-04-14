package com.alacriti.aipay.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.alacriti.aipay.model.BusinessType;
import com.alacriti.aipay.model.UserRegistration;


public class BusinessDaoHelper implements RowMapper<BusinessType> {

	@Override
	public BusinessType mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		BusinessType user = new BusinessType();	
		
		user.setBusinessTypeId(rs.getInt("business_type_id"));
		user.setBusinessId(rs.getInt("business_id"));
		user.setBusinessType(rs.getString("business_type"));
		user.setBusinessName(rs.getString("plan"));
		user.setAmount(rs.getInt("amount"));
	
		
		return user;
		
	}
	
	

}
