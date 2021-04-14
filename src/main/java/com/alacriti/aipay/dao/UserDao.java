package com.alacriti.aipay.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.alacriti.aipay.model.BusinessType;
import com.alacriti.aipay.model.Businesses;
import com.alacriti.aipay.model.Favourites;
import com.alacriti.aipay.model.TransactionDetails;
import com.alacriti.aipay.model.TransactionHistory;
import com.alacriti.aipay.model.Transactions;
import com.alacriti.aipay.model.UserCardRegistration;
import com.alacriti.aipay.model.UserRegistration;

public interface UserDao {
	public abstract int addUser(UserRegistration user) throws SQLException;
	public abstract String login(UserRegistration user) throws SQLException;
	public abstract int addUserCard(UserCardRegistration user) throws SQLException;
	public abstract List<UserRegistration> getEmployeeByEmail(String userName) throws SQLException;
	public abstract List<BusinessType> getAmountByPlan(String business,String plan) throws SQLException;
	
	public abstract List<UserCardRegistration> getCardsByUserId(int userId) throws SQLException;
	public abstract String doPayment(Transactions transactionsDetails) throws SQLException;
	
	public abstract List<UserRegistration> getProfile(int userId) throws SQLException;
	public abstract String updateUserProfile(UserRegistration user,int userId) throws SQLException;
	
	public abstract List<TransactionDetails> viewTransactions(int userId) throws SQLException;
	public abstract String addToFavourites(int userId,int businessId) throws SQLException;
	public abstract List<Favourites> getFavouriteBusinesses(int userId) throws SQLException;
	public abstract List<Businesses> getBusinesses() throws SQLException;
	
	public abstract List<TransactionHistory> getBusinessDay(int userId,String businessName,String day) throws SQLException;
	public abstract List<BusinessType> getBusinessesByType(int businessId) throws SQLException;
	public abstract List<TransactionHistory> getBusinessTypesByDay(int userId, String businessName,
			String businessType,String day) throws SQLException;
	public abstract List<TransactionHistory> getBusinessByYear(int userId, String businessName,String year) throws SQLException;
	public abstract List<TransactionHistory> getBusinessTypesByYear(int userId, String businessName,
			String businessType,String year) throws SQLException;
	public abstract List<TransactionHistory> getBusinessByMonth(int userId, String businessName, String mon) throws SQLException;
	public abstract List<TransactionHistory> getBusinessTypesByMonth(int userId, String businessName,
			String businessType, String mon) throws SQLException;
	public abstract String updatePasswordByEmail(UserRegistration user) throws SQLException;
	public abstract List<BusinessType> getAllPlans() throws SQLException;
		
}
