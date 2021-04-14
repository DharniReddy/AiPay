package com.alacriti.aipay.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alacriti.aipay.dao.UserDao;

@Service
public class BaseUserBo {

	@Autowired
	UserDao userDao;
}
