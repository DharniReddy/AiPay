package com.alacriti.aipay.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BaseUserDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
}
