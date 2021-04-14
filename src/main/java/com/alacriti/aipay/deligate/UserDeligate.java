package com.alacriti.aipay.deligate;

import org.springframework.stereotype.Service;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.alacriti.aipay.model.BusinessType;
import com.alacriti.aipay.model.Businesses;
import com.alacriti.aipay.model.Favourites;
import com.alacriti.aipay.model.TransactionDetails;
import com.alacriti.aipay.model.TransactionHistory;
import com.alacriti.aipay.model.Transactions;
import com.alacriti.aipay.model.UserCardRegistration;
import com.alacriti.aipay.model.UserRegistration;

@Service
public class UserDeligate extends BaseUserDeligate {

	Logger logger = LogManager.getLogger(UserDeligate.class);
	
	public String addUser(UserRegistration user) throws Exception {
		logger.info("addUser");
		String message = null;
		try {
			message = userBo.addUser(user);
		}
		catch(Exception e) {
			logger.error("addUser");			
		}
		return message;
	}
	
	public String login(UserRegistration employee) throws Exception {
		logger.info("login");
		try {
			return userBo.login(employee);
		}
		catch(Exception e) {
			logger.error("deleteEmployeeByName");
			throw new Exception(e);
		}
	}
	
	public String addUserCard(UserCardRegistration user) throws Exception {
		logger.info("addUserCard");
		String message = null;
		try {
			message = userBo.addUserCard(user);
		}
		catch(Exception e) {
			logger.info("addUserCard");	
		}
		return message;
	}
	
	public List<UserRegistration> getEmployeeByEmail(String name) throws Exception {
		logger.info("getEmployeeByName");
		try {
			return userBo.getEmployeeByEmail(name);
		}
		catch(Exception e) {
			logger.error("getEmployeeByName");
			throw new Exception(e);
		}
	}
	
	public List<BusinessType> getAmountByPlan(String business,String plan) throws Exception {
		logger.info("getAmountByPlan");
		try {
			return userBo.getAmountByPlan(business,plan);	
		}
		catch(Exception e) {
			logger.error("getAmountByPlan");
			throw new Exception(e);
		}
	}
	
	public List<UserCardRegistration> getCardsByUserId(int userId) throws Exception {
		logger.info("getCardsByUserId");
		try {
			return userBo.getCardsByUserId(userId);	
		}
		catch(Exception e) {
			logger.error("getCardsByUserId");
			throw new Exception(e);
		}
	}
	
	public String doPayment(Transactions transactionsDetails) throws Exception {
		logger.info("doPayment");
		try {
			return userBo.doPayment(transactionsDetails);
		}
		catch(Exception e) {
			logger.error("doPayment");
			throw new Exception(e);
		}
	}
	
	public List<UserRegistration> getProfile(int userId) throws Exception {
		logger.info("getProfile");
		try {
			return userBo.getProfile(userId);	
		}
		catch(Exception e) {
			logger.error("getProfile");
			throw new Exception(e);
		}
	}
	
	public String updateUserProfile(UserRegistration user,int userId) throws Exception{
		logger.info("updateUserProfile");
		try {
			return userBo.updateUserProfile(user,userId);	
		}
		catch(Exception e) {
			logger.error("updateUserProfile");
			throw new Exception(e);
		}
	}
	
	public String updatePasswordByEmail(UserRegistration user) throws Exception {
		logger.info("updatePasswordByEmail");
		try {
			return userBo.updatePasswordByEmail(user);
		}
		catch(Exception e) {
			logger.error("updatePasswordByEmail");
			throw new Exception(e);
		}
	}
	
	public List<TransactionDetails> viewTransactions(int userId) throws Exception {
		logger.info("viewTransactions");
		try {
			return userBo.viewTransactions(userId);	
		}
		catch(Exception e) {
			logger.error("viewTransactions");
			throw new Exception(e);
		}
	}
	
	public String addToFavourites(int userId,int businessId) throws Exception {
		logger.info("addToFavourites");
		try {
			return userBo.addToFavourites(userId,businessId);	
		}
		catch(Exception e) {
			logger.error("Exception addToFavourites");
			throw new Exception(e);
		}			
	}
	
	public List<Favourites> getFavouriteBusinesses(int userId) throws Exception {
		logger.info("getFavouriteBusinesses");
		try {
			return userBo.getFavouriteBusinesses(userId);	
		}
		catch(Exception e) {
			logger.error("getFavouriteBusinesses");
			throw new Exception(e);
		}		
	}
	
	public List<Businesses> getBusinesses() throws Exception {
		logger.info("getBusinesses");
		try {
			return userBo.getBusinesses();	
		}
		catch(Exception e) {
			logger.error("getBusinesses");
			throw new Exception(e);
		}		
	}
	
	public List<BusinessType> getAllPlans() throws Exception {
		logger.info("getAllPlans");
		try {
			return userBo.getAllPlans();	
		}
		catch(Exception e) {
			logger.error("getAllPlans");
			throw new Exception(e);
		}		
	}
	
	public List<BusinessType> getBusinessesByType(int businessId) throws Exception {
		logger.info("getBusinessesByType");
		try {
			return userBo.getBusinessesByType(businessId);	
		}
		catch(Exception e) {
			logger.error("getBusinessesByType");
			throw new Exception(e);
		}		
	}
	
	public List<TransactionHistory> getBusinessDay(int userId,String businessName,String day) throws Exception{
		logger.info("getBusinessDay");
		try {
			return userBo.getBusinessDay(userId,businessName,day);	
		}
		catch(Exception e) {
			logger.error("getBusinessDay");
			throw new Exception(e);
		}		
	}
	
	public List<TransactionHistory> getBusinessTypesByDay(int userId,String businessName,String businessType,String day) throws Exception{
		logger.info("getBusinessTypesByDay");
		try {
			return userBo.getBusinessTypesByDay(userId,businessName,businessType,day);	
		}
		catch(Exception e) {
			logger.error("getBusinessTypesByDay");
			throw new Exception(e);
		}		
	}
	
	public List<TransactionHistory> getBusinessByYear(int userId,String businessName,String year) throws Exception {
		logger.info("getBusinessByYear");
		try {
			return userBo.getBusinessByYear(userId,businessName,year);		
		}
		catch(Exception e) {
			logger.error("getBusinessByYear");
			throw new Exception(e);
		}				
	}
	
	public List<TransactionHistory> getBusinessTypesByYear(int userId,String businessName,String businessType,String year) throws Exception {
		logger.info("getBusinessTypesByYear");
		try {
			return userBo.getBusinessTypesByYear(userId,businessName,businessType,year);	
		}
		catch(Exception e) {
			logger.error("getBusinessTypesYear");
			throw new Exception(e);
		}		
	}
	
	public List<TransactionHistory> getBusinessByMonth(int userId,String businessName,String mon) throws Exception {
		logger.info("getBusinessByMonth");
		try {
			return userBo.getBusinessByMonth(userId,businessName,mon);		
		}
		catch(Exception e) {
			logger.error("getBusinessByMonth");
			throw new Exception(e);
		}					
	}
	public List<TransactionHistory> getBusinessTypesByMonth(int userId,String businessName,String businessType,String mon) throws Exception {	
		logger.info("getBusinessTypesByMonth");
		try {
			return userBo.getBusinessTypesByMonth(userId,businessName,businessType,mon);	
		}
		catch(Exception e) {
			logger.error("getBusinessTypesMonth");
			throw new Exception(e);
		}		
	}
}
