package com.alacriti.aipay.bo;


import org.springframework.stereotype.Service;


import com.alacriti.aipay.model.BusinessType;
import com.alacriti.aipay.model.Businesses;
import com.alacriti.aipay.model.Favourites;
import com.alacriti.aipay.model.TransactionDetails;
import com.alacriti.aipay.model.TransactionHistory;
import com.alacriti.aipay.model.Transactions;
import com.alacriti.aipay.model.UserCardRegistration;
import com.alacriti.aipay.model.UserRegistration;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Service
public class UserBo extends BaseUserBo{
	
Logger logger=LogManager.getLogger(UserBo.class);
	
	public String addUser(UserRegistration employee) throws Exception {
		logger.info("addUser");
		try {		
			int result = userDao.addUser(employee);		
			if(result == 1) {
				return "Successfully Registered";
			}
			else {
				return "UserName already exist";
			}	
		}
		catch(Exception e) {
			logger.error("addUser");
			throw new Exception(e);
		}
	}
	
	public String login(UserRegistration employee) throws Exception{
		logger.info("login");
		try {
			return userDao.login(employee);
		}
		catch(Exception e) {
			logger.error("login");
			throw new Exception(e);
		}
	}	
	
	public String addUserCard(UserCardRegistration employee) throws Exception {
		logger.info("addUserCard");
		try {		
			int result= userDao.addUserCard(employee);
			if(result == 1) {
				return "Successfully Registered";
			}
			else {
				return "UserName already exist";
			}	
		}	
		catch(Exception e) {
			logger.error("addUserCard");
			throw new Exception(e);
		}
	}
	
	public List<UserRegistration> getEmployeeByEmail(String email) throws Exception {
		logger.info("getEmployeeByName");
		try {
			return userDao.getEmployeeByEmail(email);
		}
		catch(Exception e) {
			logger.error("getEmployeeByName");
			throw new Exception(e);
		}
	}
	
	public List<BusinessType> getAmountByPlan(String business,String plan) throws Exception {
		logger.info("getAmountByPlan");
		try {
			return userDao.getAmountByPlan(business,plan);		
		}
		catch(Exception e) {
			logger.error("getAmountByPlan");
			throw new Exception(e);
		}
	}

	public List<UserCardRegistration> getCardsByUserId(int userId) throws Exception {
		logger.info("getCardsByUserId");
		try {
			return userDao.getCardsByUserId(userId);	
		}
		catch(Exception e) {
			logger.error("getCardsByUserId");
			throw new Exception(e);
		}
	}
	
	public String doPayment(Transactions transactionsDetails) throws Exception {
		logger.info("doPayment");
		try {
			return userDao.doPayment(transactionsDetails);	
		}
		catch(Exception e) {
			logger.error("doPayment");
			throw new Exception(e);
		}
	}
	
	public List<UserRegistration> getProfile(int userId) throws Exception {
		logger.info("getProfile");
		try {
			return userDao.getProfile(userId);	
		}
		catch(Exception e) {
			logger.error("getProfile");
			throw new Exception(e);
		}
	}
	
	public String updateUserProfile(UserRegistration user,int userId)throws Exception {
		logger.info("updateUserProfile");
		try {
			return userDao.updateUserProfile(user,userId);	
		}
		catch(Exception e) {
			logger.error("updateUserProfile");
			throw new Exception(e);
		}
	}
	
	public String updatePasswordByEmail(UserRegistration user) throws Exception {
		logger.info("updatePasswordByEmail");
		try {
			return userDao.updatePasswordByEmail(user);
		}
		catch(Exception e) {
			logger.error("updatePasswordByEmail");
			throw new Exception(e);
		}
	}
	
	public List<TransactionDetails> viewTransactions(int userId) throws Exception {
		logger.info("viewTransactions");
		try {
			return userDao.viewTransactions(userId);
		}
		catch(Exception e) {
			logger.error("viewTransactions");
			throw new Exception(e);
		}
	}
	
	public String addToFavourites(int userId,int businessId) throws Exception {
		logger.info("addToFavourites");
		try {
			return userDao.addToFavourites(userId,businessId);	
		}
		catch(Exception e) {
			logger.error("addToFavourites");
			throw new Exception(e);
		}		
	}
	
	public List<Favourites> getFavouriteBusinesses(int userId) throws Exception {
		logger.info("getFavouriteBusinesses");
		try {
			return userDao.getFavouriteBusinesses(userId);	
		}
		catch(Exception e) {
			logger.error("getFavouriteBusinesses");
			throw new Exception(e);
		}		
	}
	
	public List<Businesses> getBusinesses() throws Exception {
		logger.info("getBusinesses");
		try {
			return userDao.getBusinesses();	
		}
		catch(Exception e) {
			logger.error("Exception getFavouriteBusinesses");
			throw new Exception(e);
		}		
	}
	
	public List<BusinessType> getAllPlans() throws Exception {
		logger.info("getAllPlans");
		try {
			return userDao.getAllPlans();	
		}
		catch(Exception e) {
			logger.error("getAllPlans");
			throw new Exception(e);
		}		
	}
	
	public List<BusinessType> getBusinessesByType(int businessId) throws Exception {
		logger.info("getBusinessesByType");
		try {
			return userDao.getBusinessesByType(businessId);	
		}
		catch(Exception e) {
			logger.error("getBusinessesByType");
			throw new Exception(e);
		}		
	}
	
	public List<TransactionHistory> getBusinessDay(int userId,String businessName,String day) throws Exception{
		logger.info("getBusinessDay");
		try {
			return userDao.getBusinessDay(userId,businessName,day);	
		}
		catch(Exception e) {
			logger.error("getBusinessDay");
			throw new Exception(e);
		}		
	}
	
	public List<TransactionHistory> getBusinessTypesByDay(int userId,String businessName,String businessType,String day) throws Exception{
		logger.info("getBusinessTypesByDay");
		try {
			return userDao.getBusinessTypesByDay(userId,businessName,businessType,day);	
		}
		catch(Exception e) {
			logger.error("getBusinessTypesByDay");
			throw new Exception(e);
		}		
	}
	public List<TransactionHistory> getBusinessByYear(int userId,String businessName,String year) throws Exception {
		logger.info("getBusinessByYear");
		try {
			return userDao.getBusinessByYear(userId,businessName,year);		
		}
		catch(Exception e) {
			logger.error("getBusinessByYear");
			throw new Exception(e);
		}				
	}
	
	public List<TransactionHistory> getBusinessTypesByYear(int userId,String businessName,String businessType,String year) throws Exception {	
		logger.info("getBusinessTypesByYear");
		try {
			return userDao.getBusinessTypesByYear(userId,businessName,businessType,year);	
		}
		catch(Exception e) {
			logger.error("getBusinessTypesYear");
			throw new Exception(e);
		}		
	}
	
	public List<TransactionHistory> getBusinessByMonth(int userId,String businessName,String mon) throws Exception {
		logger.info("getBusinessByMonth");
		try {
			return userDao.getBusinessByMonth(userId,businessName,mon);		
		}
		catch(Exception e) {
			logger.error("getBusinessByMonth");
			throw new Exception(e);
		}				
	}
	
	public List<TransactionHistory> getBusinessTypesByMonth(int userId,String businessName,String businessType,String mon) throws Exception {	
		logger.info("getBusinessTypesByMonth");
		try {
			return userDao.getBusinessTypesByMonth(userId,businessName,businessType,mon);	
		}
		catch(Exception e) {
			logger.error("getBusinessTypesMonth");
			throw new Exception(e);
		}		
	}

}
