package com.alacriti.aipay.resource;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alacriti.aipay.deligate.UserDeligate;
import com.alacriti.aipay.model.BusinessType;
import com.alacriti.aipay.model.Businesses;
import com.alacriti.aipay.model.Favourites;
import com.alacriti.aipay.model.TransactionDetails;
import com.alacriti.aipay.model.TransactionHistory;
import com.alacriti.aipay.model.Transactions;
import com.alacriti.aipay.model.UserCardRegistration;
import com.alacriti.aipay.model.UserRegistration;

@RestController
public class UserResource {
	Logger logger = LogManager.getLogger(UserResource.class);
	
	@Autowired
	UserDeligate userDeligate;
	
	@PostMapping("/register")
	@CrossOrigin
	public ResponseEntity<?> addUser(@RequestBody UserRegistration user) throws Exception {
		logger.info("addUser");
		String result=null;
		try {
			result=userDeligate.addUser(user);
			return new ResponseEntity<>(result,HttpStatus.OK);	
		}
		catch(Exception e)
		{
			logger.error("addUser");
			return new ResponseEntity<>(result,HttpStatus.NOT_FOUND);
		}	
	}
	
	@RequestMapping(value="/login",consumes="application/json", method=RequestMethod.POST)
	@CrossOrigin
	public ResponseEntity<?> login(@RequestBody UserRegistration employee) throws Exception {
		logger.info("login");
		String result=null;
		try {
			result=userDeligate.login(employee);
			return new ResponseEntity<>(result,HttpStatus.OK);			
		}
		catch(Exception e)
		{
			logger.error("login");
			return new ResponseEntity<>(result,HttpStatus.NOT_FOUND);
		}	
	}
	
	@PostMapping("/addcard")
	@CrossOrigin
	public ResponseEntity<?> addUserCard(@RequestBody UserCardRegistration user) throws Exception {
		logger.info("addUserCard");
		String result =null;
		try {
			 result=userDeligate.addUserCard(user);
			return new ResponseEntity<>(result,HttpStatus.OK);
		}
		catch(Exception e)
		{
			logger.info("addUserCard");
			return new ResponseEntity<>(result,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getUserByEmail/{name}")
	@CrossOrigin
	public ResponseEntity<List<UserRegistration>> getUser(@PathVariable("name") String name) throws Exception {
		logger.info("getUser");
		List<UserRegistration> user = null;
		try {
			user =userDeligate.getEmployeeByEmail(name);
			return new ResponseEntity<>(user,HttpStatus.OK);
		}
		catch(Exception e){
			logger.error("getUser");
			return new ResponseEntity<>(user,HttpStatus.NOT_FOUND);
		}
	}	
	
	@GetMapping("/getplans/{business}/{plan}")
	@CrossOrigin
	public ResponseEntity<List<BusinessType>> getAmountByPlan(@PathVariable("business") String business,@PathVariable("plan") String plan) throws Exception {
		logger.info("getAmountByPlan");
		List<BusinessType> userbusiness = null;
		try {
			userbusiness =userDeligate.getAmountByPlan(business,plan);
			return new ResponseEntity<>(userbusiness,HttpStatus.OK);
		}
		catch(Exception e){
			logger.error("getAmountByPlan");
			return new ResponseEntity<>(userbusiness,HttpStatus.NOT_FOUND);
		}	
	}
	
	@GetMapping("/getcards/{userId}")
	@CrossOrigin
	public ResponseEntity<List<UserCardRegistration>> getCardsByUserId(@PathVariable("userId") int userId) throws Exception {
		logger.info("getCardsByUserId");
		List<UserCardRegistration> userCard = null;
		try {
			userCard =userDeligate.getCardsByUserId(userId);
			return new ResponseEntity<>(userCard,HttpStatus.OK);	
		}
		catch(Exception e){
			logger.error("getCardsByUserId");
			return new ResponseEntity<>(userCard,HttpStatus.NOT_FOUND);	
		}	
	}
	
	@PostMapping("/payment")
	@CrossOrigin
	public ResponseEntity<?> doPayment(@RequestBody Transactions transactionsDetails) throws Exception {	
		logger.info("doPayment");
		String userTransaction =null;
		try {
			userTransaction =userDeligate.doPayment(transactionsDetails);
			return new ResponseEntity<>(userTransaction,HttpStatus.OK);	
		}
		catch(Exception e){
			logger.error("doPayment");
			return new ResponseEntity<>(userTransaction,HttpStatus.NOT_FOUND);	
		}		
	}
	
	@GetMapping("/profile/{userId}")
	@CrossOrigin
	public ResponseEntity<List<UserRegistration>> getProfile(@PathVariable("userId") int userId) throws Exception {
		logger.info("getProfile");
		List<UserRegistration> userProfile = null ;
		try {
			userProfile = userDeligate.getProfile(userId);
			return new ResponseEntity<>(userProfile,HttpStatus.OK);	
		}
		catch(Exception e){
			logger.error("getProfile");
			return new ResponseEntity<>(userProfile,HttpStatus.NOT_FOUND);	
		}	
	}
	
	@PutMapping("/updateprofile/{userId}")
	@CrossOrigin
	public ResponseEntity<?> updateUserProfile(@RequestBody UserRegistration user,@PathVariable("userId") int userId) throws Exception {
		logger.info("updateUserProfile");
		String updateProfile = null;
		try {
			updateProfile = userDeligate.updateUserProfile(user,userId);
			return new ResponseEntity<>(updateProfile,HttpStatus.OK);	
		}
		catch(Exception e){
			logger.error("updateUserProfile");
			return new ResponseEntity<>(updateProfile,HttpStatus.NOT_FOUND);	
		}		
	}
		
	@PutMapping("/forgotPassword")
	@CrossOrigin
	public ResponseEntity<?> updatePasswordByEmail(@RequestBody UserRegistration user) throws Exception {
		logger.info("updatePasswordByEmail");
		String updatePassword = null;
		try {
			updatePassword = userDeligate.updatePasswordByEmail(user);
			return new ResponseEntity<>(updatePassword,HttpStatus.OK);	
		}
		catch(Exception e){
			logger.error("updatePasswordByEmail");
			return new ResponseEntity<>(updatePassword,HttpStatus.NOT_FOUND);	
		}		
	}
	
	@GetMapping("/viewtransactions/{userId}")
	@CrossOrigin
	public ResponseEntity<List<TransactionDetails>> viewTransactions(@PathVariable("userId") int userId) throws Exception {
		logger.info("viewTransactions");
		List<TransactionDetails> userTransaction = null ;
		try {
			userTransaction = userDeligate.viewTransactions(userId);
			return new ResponseEntity<>(userTransaction,HttpStatus.OK);	
		}
		catch(Exception e){
			logger.info("viewTransactions");
			return new ResponseEntity<>(userTransaction,HttpStatus.NOT_FOUND);	
		}		
	}
	
	@PostMapping("/favourites/{userId}/{businessId}")
	@CrossOrigin
	public ResponseEntity<?> addToFavourites(@PathVariable("userId") int userId,@PathVariable("businessId") int businessId) throws Exception {
		logger.info("addToFavourites");
		String userFavourite = null;
		try {
			userFavourite  = userDeligate.addToFavourites(userId,businessId);	
			return new ResponseEntity<>(userFavourite,HttpStatus.OK);	
		}
		catch(Exception e){
			logger.error("addToFavourites");
			return new ResponseEntity<>(userFavourite,HttpStatus.NOT_FOUND);	
		}	
	}
	
	@GetMapping("/getfavourites/{userId}")
	@CrossOrigin
	public ResponseEntity<List<Favourites>> getFavouriteBusinesses(@PathVariable("userId") int userId) throws Exception {
		logger.info("getFavouriteBusinesses");
		List<Favourites> userFavourite = null;
		try {
			userFavourite  = userDeligate.getFavouriteBusinesses(userId);	
			return new ResponseEntity<>(userFavourite,HttpStatus.OK);	
		}
		catch(Exception e){
			logger.error("getFavouriteBusinesses");
			return new ResponseEntity<>(userFavourite,HttpStatus.NOT_FOUND);	
		}	
	}
	
	@GetMapping("/getbusinesses")
	@CrossOrigin
	public ResponseEntity<List<Businesses>> getBusinesses() throws Exception {	
		logger.info("getBusinesses");
		List<Businesses> userBusiness = null;
		try {
			userBusiness = userDeligate.getBusinesses();
			return new ResponseEntity<>(userBusiness,HttpStatus.OK);	
		}
		catch(Exception e){
			logger.error("getBusinesses");
			return new ResponseEntity<>(userBusiness,HttpStatus.NOT_FOUND);	
		}		
	}
	
	@GetMapping("/getallplans")
	@CrossOrigin
	public ResponseEntity<List<BusinessType>> getAllPlans() throws Exception {
		logger.info("getAllPlans");
		List<BusinessType> userPlans = null;
		try {
			userPlans = userDeligate.getAllPlans();
			return new ResponseEntity<>(userPlans,HttpStatus.OK);	
		}
		catch(Exception e){
			logger.error("getAllPlans");
			return new ResponseEntity<>(userPlans,HttpStatus.NOT_FOUND);	
		}	
	}
	
	@GetMapping("/getbusinesstypes/{businessId}")
	@CrossOrigin
	public ResponseEntity<List<BusinessType>> getBusinessesByType(@PathVariable("businessId") int businessId) throws Exception {
		logger.info("getBusinessesByType");
		List<BusinessType> userBusiness = null;
		try {
			userBusiness = userDeligate.getBusinessesByType(businessId);
			return new ResponseEntity<>(userBusiness,HttpStatus.OK);	
		}
		catch(Exception e){
			logger.info("getBusinessesByType");
			return new ResponseEntity<>(userBusiness,HttpStatus.NOT_FOUND);	
		}	
	}
	
	@GetMapping("/getday/{userId}/{businessName}/{day}")
	@CrossOrigin
	public ResponseEntity<List<TransactionHistory>> getBusinessDay(@PathVariable("userId") int userId,@PathVariable("businessName") String businessName,@PathVariable("day") String day) throws Exception {
		logger.info("getBusinessDay");
		List<TransactionHistory> userBusiness = null;
		try {
			userBusiness = userDeligate.getBusinessDay(userId,businessName,day);
			return new ResponseEntity<>(userBusiness,HttpStatus.OK);	
		}
		catch(Exception e){
			logger.info("getBusinessDay");
			return new ResponseEntity<>(userBusiness,HttpStatus.NOT_FOUND);	
		}	
	}
	
	@GetMapping("/getdaybybusinesstype/{userId}/{businessName}/{businessType}/{day}")
	@CrossOrigin
	public ResponseEntity<List<TransactionHistory>> getBusinessTypesByDay(@PathVariable("userId") int userId,@PathVariable("businessName") String businessName,@PathVariable("businessType") String businessType,@PathVariable("day") String day) throws Exception {
		logger.info("getBusinessTypesByDay");
		List<TransactionHistory> userBusiness = null;
		try {
			userBusiness = userDeligate.getBusinessTypesByDay(userId,businessName,businessType,day);
			return new ResponseEntity<>(userBusiness,HttpStatus.OK);	
		}
		catch(Exception e){
			logger.error("getBusinessTypesByDay");
			return new ResponseEntity<>(userBusiness,HttpStatus.NOT_FOUND);	
		}	
	}
	
	@GetMapping("/getbusinessbyyear/{userId}/{businessName}/{year}")
	@CrossOrigin
	public ResponseEntity<List<TransactionHistory>> getBusinessByYear(@PathVariable("userId") int userId,@PathVariable("businessName") String businessName,@PathVariable("year") String year) throws Exception {
		logger.info("getBusinessByYear");
		List<TransactionHistory> userBusiness = null;
		try {
			userBusiness = userDeligate.getBusinessByYear(userId,businessName,year);
			return new ResponseEntity<>(userBusiness,HttpStatus.OK);	
		}
		catch(Exception e){
			logger.error("getBusinessByYear");
			return new ResponseEntity<>(userBusiness,HttpStatus.NOT_FOUND);	
		}		
	}
	
	@GetMapping("/getbusinesstypebyyear/{userId}/{businessName}/{businessType}/{year}")
	@CrossOrigin
	public ResponseEntity<List<TransactionHistory>> getBusinessTypesByYear(@PathVariable("userId") int userId,@PathVariable("businessName") String businessName,@PathVariable("businessType") String businessType,@PathVariable("year") String year) throws Exception {
		logger.info("getBusinessTypesByYear");
		List<TransactionHistory> userBusiness = null;
		try {
			userBusiness = userDeligate.getBusinessTypesByYear(userId,businessName,businessType,year);
			return new ResponseEntity<>(userBusiness,HttpStatus.OK);	
		}
		catch(Exception e){
			logger.error("getBusinessTypesByYear");
			return new ResponseEntity<>(userBusiness,HttpStatus.NOT_FOUND);	
		}
	}
	
	@GetMapping("/getbusinessbymonth/{userId}/{businessName}/{mon}")
	@CrossOrigin
	public ResponseEntity<List<TransactionHistory>> getBusinessByMonth(@PathVariable("userId") int userId,@PathVariable("businessName") String businessName,@PathVariable("mon") String mon) throws Exception {
		logger.info("getBusinessByMonth");
		List<TransactionHistory> userBusiness = null;
		try {
			userBusiness = userDeligate.getBusinessByMonth(userId,businessName,mon);
			return new ResponseEntity<>(userBusiness,HttpStatus.OK);	
		}
		catch(Exception e){
			logger.error("getBusinessByMonth");
			return new ResponseEntity<>(userBusiness,HttpStatus.NOT_FOUND);	
		}
	}
	
	@GetMapping("/getbusinesstypebymonth/{userId}/{businessName}/{businessType}/{mon}")
	@CrossOrigin
	public ResponseEntity<List<TransactionHistory>> getBusinessTypesByMonth(@PathVariable("userId") int userId,@PathVariable("businessName") String businessName,@PathVariable("businessType") String businessType,@PathVariable("mon") String mon) throws Exception {
		logger.info("getBusinessTypesByMonth");
		List<TransactionHistory> userBusiness = null;
		try {
			userBusiness = userDeligate.getBusinessTypesByMonth(userId,businessName,businessType,mon);
			return new ResponseEntity<>(userBusiness,HttpStatus.OK);	
		}
		catch(Exception e){
			logger.error("getBusinessTypesByMonth");
			return new ResponseEntity<>(userBusiness,HttpStatus.NOT_FOUND);	
		}
			
	}
	
}
