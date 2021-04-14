package com.alacriti.aipay.dao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.alacriti.aipay.model.BusinessType;
import com.alacriti.aipay.model.Businesses;
import com.alacriti.aipay.model.Favourites;
import com.alacriti.aipay.model.TransactionDetails;
import com.alacriti.aipay.model.TransactionHistory;
import com.alacriti.aipay.model.Transactions;
import com.alacriti.aipay.model.UserCardRegistration;
import com.alacriti.aipay.model.UserRegistration;

@Repository
public class UserDaoImplementation extends BaseUserDao implements UserDao {

	Logger logger = LogManager.getLogger(UserDao.class);
	
	public int addUser(UserRegistration user) throws SQLException{
		logger.info("addUser");
		int ps=0;
		try {	
			ps=jdbcTemplate.update(SqlQueries.CREATE_USER_SQL,user.getUsername(),user.getPassword(),user.getEmail(),user.getMobilenumber(),user.getDob());	
		}
		catch(Exception e)
		{
			ps=0;
			logger.error("addUser");
		}	
		return ps;
	}
	
	public String login(UserRegistration user) throws SQLException{
		logger.info("login");
		UserRegistration employee;
		String result ;
		try {
			employee=jdbcTemplate.queryForObject(SqlQueries.GET_EMPLOYEE_SQL, new DaoHelper(),user.getEmail());
			 if(user.getPassword().equals(employee.getPassword())) {
					result = "1";
			 }
			 else{
				 result = "Password is incorrect";
			 }
		}catch(Exception e) {
			result = "UserName is incorrect";	
		}	
		return result;
	}
	
	public int addUserCard(UserCardRegistration user) throws SQLException{
		logger.info("addUserCard");
		int ps=0;
		try {
			ps=jdbcTemplate.update(SqlQueries.INSERT_CARD_SQL,user.getUserId(),user.getCardNumber(),user.getCardHolderName(),user.getCardType(),user.getCardExpiryDate());	
		}
		catch(Exception e)
		{
			ps=0;
			logger.error("addUserCard");
		}	
		return ps;
	}	
	
	public List<UserRegistration> getEmployeeByEmail(String userName) throws SQLException{
		logger.info("getEmployeeByName");
		try {					
			return jdbcTemplate.query(SqlQueries.GET_EMPLOYEE_SQL, new DaoHelper(),userName);			
		}
		catch(Exception e) {
			logger.error("getEmployeeByName");
			throw new SQLException(e);
		}
	}
	
	public List<BusinessType> getAmountByPlan(String business,String plan) throws SQLException {
		logger.info("getAmountByPlan");
		try {		
			return jdbcTemplate.query(SqlQueries.GET_PLAN_SQL, new BeanPropertyRowMapper<>(BusinessType.class),business,plan);
		}
		catch(Exception e) {
			logger.error("getAmountByPlan");
			throw new SQLException(e);
		}		
	}
	
	public List<UserCardRegistration> getCardsByUserId(int userId) throws SQLException {
		logger.info("getCardsByUserId");
		try {		
			return jdbcTemplate.query(SqlQueries.GET_CARDS_SQL, new UserCardDaoHelper(),userId);
		}
		catch(Exception e) {
			logger.error("getCardsByUserId");
			throw new SQLException(e);
		}	
	}
	
	public String doPayment(Transactions user) throws SQLException {
		String result ="0" ;
		logger.info("doPayment");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
		LocalDate localDate = LocalDate.now();
		try {
			jdbcTemplate.update(SqlQueries.INSERT_TRANSACTION_SQL,user.getUserId(),user.getCardId(),user.getBusinessTypeId(),user.getPlanAmount(),user.getMobileNumber(),localDate);	
			result ="payment successful" ;
		}
		catch(Exception e)
		{
			result ="Payment was unsuccessful" ;
		}	
		return result;
	}	
	
	public List<UserRegistration> getProfile(int userId) throws SQLException{
		logger.info("getProfile");
		try {				
			return jdbcTemplate.query(SqlQueries.GET_PROFILE_SQL, new DaoHelper(),userId);		
		}
		catch(Exception e) {
			logger.error("getProfile");
			throw new SQLException(e);
		}
	}
	
	public String updateUserProfile(UserRegistration user,int userId)throws SQLException {
		logger.info("updateUserProfile");
		String result="0";
		try {				
			jdbcTemplate.update(SqlQueries.UPDATE_PROFILE_SQL,user.getUsername(),user.getEmail(),user.getMobilenumber(),user.getDob(),user.getProfilePic(),userId);
			result ="Profile Updated successfully";
		}
		catch(Exception e) {
			logger.error("updateUserProfile");
			result="payment unsuccessful";
		}
		return result;
	}
	
	public String updatePasswordByEmail(UserRegistration user) throws SQLException {
		logger.info("updatePasswordByEmail");
		UserRegistration emp;
		String result = null;
		try {		 
		 emp=jdbcTemplate.queryForObject(SqlQueries.GET_EMPLOYEE_EMAIL_SQL, new DaoHelper(),user.getEmail());
		 System.out.println(emp.getEmail());
		 if(user.getEmail().equals(emp.getEmail())) {			 	
				jdbcTemplate.update(SqlQueries.FORGOT_PASSWORD_EMPLOYEE_SQL,user.getPassword(),user.getEmail());
				result = "Password updated successfully";
			}
		}catch(Exception e){
			logger.error("updatePasswordByEmail");
			result = "Email is not registered";
		}
		return result;	
	}
	
	public List<TransactionDetails> viewTransactions(int userId) throws SQLException {
		logger.info("viewTransactions");
		try {		
		
			return jdbcTemplate.query(SqlQueries.GET_TRANSACTIONS_SQL, new BeanPropertyRowMapper<>(TransactionDetails.class),userId);
			
		}
		catch(Exception e) {
			logger.error("viewTransactions");
			throw new SQLException(e);
		}
	}
	
	public String addToFavourites(int userId,int businessId) throws SQLException {
		logger.info("addToFavourites");
		List<Favourites> result;
		String outcome;	
		try {				
			result=jdbcTemplate.query(SqlQueries.GET_FAVOURITES_SQL, new BeanPropertyRowMapper<>(Favourites.class),userId,businessId);
			boolean ans = result.isEmpty();
			if(ans == true) {
				jdbcTemplate.update(SqlQueries.INSERT_FAVOURITE_BUSINESS_SQL,userId,businessId);	
				outcome ="Successfully added to favourites";
			}
			else {
				outcome ="You have already added to favourites" ;
			}		
		}
		catch(Exception e) {
			logger.error("addToFavourites");
			throw new SQLException(e);
		}
		return outcome ;
	}
	
	public List<Favourites> getFavouriteBusinesses(int userId) throws SQLException {
		logger.info("getFavouriteBusinesses");
		try {		
			
			return jdbcTemplate.query(SqlQueries.GET_USERFAVOURITES_SQL, new BeanPropertyRowMapper<>(Favourites.class),userId);		
		}
		catch(Exception e) {
			logger.error("getFavouriteBusinesses");
			throw new SQLException(e);
		}
	}
	
	public List<Businesses> getBusinesses() throws SQLException {
		logger.info("getBusinesses");
		try {			
			return jdbcTemplate.query(SqlQueries.GET_BUSINESSES_SQL, new BeanPropertyRowMapper<>(Businesses.class));			
		}
		catch(Exception e) {
			logger.error("getBusinesses");	
			throw new SQLException(e);
		}
	}
	
	public List<BusinessType> getAllPlans() throws SQLException {
		logger.info("getAllPlans");
		try {				
			return jdbcTemplate.query(SqlQueries.GET_ALL_PLANS_SQL, new BeanPropertyRowMapper<>(BusinessType.class));		
		}
		catch(Exception e) {
			logger.error("getAllPlans");
			throw new SQLException(e);
		}
	}
	
	public List<BusinessType> getBusinessesByType(int businessId) throws SQLException {
		logger.info("getBusinessesByType");
		try {				
			return jdbcTemplate.query(SqlQueries.GET_BUSINESSES_BY_TYPE_SQL, new BeanPropertyRowMapper<>(BusinessType.class),businessId);		
		}
		catch(Exception e) {
			logger.error("getBusinesseByType");
			throw new SQLException(e);
		}
	}
	
	public List<TransactionHistory> getBusinessDay(int userId,String businessName,String day) throws SQLException{
		logger.info("getBusinessDay");
		try {			
			return jdbcTemplate.query(SqlQueries.GET_BUSINESSES_BY_DAY, new BeanPropertyRowMapper<>(TransactionHistory.class),userId,businessName,day);			
		}
		catch(Exception e) {
			logger.error("getBusinessDay");	
			throw new SQLException(e);
		}
	}
	
	public List<TransactionHistory> getBusinessTypesByDay(int userId,String businessName,String businessType,String day) throws SQLException{
		logger.info("getBusinessTypesByDay");
		try {
			return jdbcTemplate.query(SqlQueries.GET_BUSINESSES_TYPES_BY_DAY, new BeanPropertyRowMapper<>(TransactionHistory.class),userId,businessName,businessType,day);	
		}
		catch(Exception e) {
			logger.error("getBusinessTypesByDay");
			throw new SQLException(e);
		}
	}
	
	public List<TransactionHistory> getBusinessByYear(int userId,String businessName,String year) throws SQLException{
		logger.info("getBusinessByYear");
		try {					
			return jdbcTemplate.query(SqlQueries.GET_BUSINESSES_BY_YEAR, new BeanPropertyRowMapper<>(TransactionHistory.class),userId,businessName,year);		
		}
		catch(Exception e) {
			logger.error("getBusinessByYear");
			System.out.println(e);
			
			throw new SQLException(e);
		}
	}
	
	public List<TransactionHistory> getBusinessTypesByYear(int userId,String businessName,String businessType,String year) throws SQLException{
		logger.info("getBusinessTypesByYear");
		try {
			return jdbcTemplate.query(SqlQueries.GET_BUSINESSES_TYPES_BY_YEAR, new BeanPropertyRowMapper<>(TransactionHistory.class),userId,businessName,businessType,year);	
		}
		catch(Exception e) {
			logger.error("getBusinessTypesByYear");
			throw new SQLException(e);
		}		
	}
	
	public List<TransactionHistory> getBusinessByMonth(int userId,String businessName,String mon) throws SQLException{
		logger.info("getBusinessByMonth");
		try {				
			return jdbcTemplate.query(SqlQueries.GET_BUSINESSES_BY_MONTH, new BeanPropertyRowMapper<>(TransactionHistory.class),userId,businessName,mon);		
		}
		catch(Exception e) {
			logger.error("getBusinessByMonth");
			throw new SQLException(e);
		}
	}
	
	public List<TransactionHistory> getBusinessTypesByMonth(int userId,String businessName,String businessType,String mon) throws SQLException{
		logger.info("getBusinessTypesByMonth");
		try {
			return jdbcTemplate.query(SqlQueries.GET_BUSINESSES_TYPES_BY_MONTH, new BeanPropertyRowMapper<>(TransactionHistory.class),userId,businessName,businessType,mon);	
		}
		catch(Exception e) {
			logger.error("getBusinessTypesByMonth");
			throw new SQLException(e);
		}		
	}

}
