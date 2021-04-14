package com.alacriti.aipay.dao;

public class SqlQueries {
	static String GET_EMPLOYEE_SQL ="SELECT *FROM Al399_user_details WHERE email=?";
	static String CREATE_USER_SQL ="INSERT INTO Al399_user_details(username,password,email,mobilenumber,dob) VALUES(?,?,?,?,?)";


	static String GET_EMPLOYEE_EMAIL_SQL ="SELECT *FROM Al399_user_details where email=?";
	static String FORGOT_PASSWORD_EMPLOYEE_SQL="UPDATE Al399_user_details set password=? where email=?";
	static String INSERT_CARD_SQL="INSERT INTO Al399_user_card_details(user_id,card_number,card_holder_name,card_type,expiry_date) VALUES(?,?,?,?,?)";
	static String GET_PLAN_SQL="select * from Al399_business_type_table WHERE business_type=? and plan=?"; 
	static String GET_CARDS_SQL="select * from Al399_user_card_details WHERE user_id=?";	
	static String INSERT_TRANSACTION_SQL ="INSERT INTO Al399_transactions_table(user_id,card_id,business_type_id,plan_amount,mobile_number,payment_date) VALUES(?,?,?,?,?,?)";
	static String GET_PROFILE_SQL ="SELECT *FROM Al399_user_details WHERE uid=?";
	static String UPDATE_PROFILE_SQL ="UPDATE Al399_user_details SET username=?,email=?,mobilenumber=?,dob=?,profile_pic=? WHERE uid=?";	

	
	static String GET_TRANSACTIONS_SQL ="select t.plan_amount,t.mobile_number,b.business_type,u.username,bm.business_name,t.payment_date\n"
			+ "from Al399_transactions_table as t join Al399_business_type_table as b \n"
			+ "join Al399_user_details as u  join Al399_business_master_table as bm where t.user_id=u.uid and t.business_type_id=b.business_type_id and bm.business_id=b.business_id and t.user_id=?;";
	
	static String GET_FAVOURITES_SQL ="SELECT *FROM Al399_favourites_table WHERE user_id=? and business_id=?";
	static String INSERT_FAVOURITE_BUSINESS_SQL ="INSERT INTO Al399_favourites_table(user_id,business_id)VALUES(?,?)";
	static String GET_USERFAVOURITES_SQL= "select f.user_id,f.business_id,b.business_name from Al399_favourites_table as f join Al399_business_master_table as b where b.business_id=f.business_id and f.user_id=?";
	static String GET_BUSINESSES_SQL ="SELECT *FROM Al399_business_master_table";
	
	static String GET_BUSINESSES_BY_TYPE_SQL = "SELECT DISTINCT business_type from Al399_business_type_table where business_id=?";
	
	static String GET_ALL_PLANS_SQL ="SELECT DISTINCT plan from Al399_business_type_table";
	
	static String GET_BUSINESSES_BY_DAY ="select count(*),t.plan_amount,b.business_type,u.username,bm.business_name,t.payment_date\n"
			+ "from Al399_transactions_table as t join Al399_business_type_table as b \n"
			+ "join Al399_user_details as u  join Al399_business_master_table as bm where t.user_id=u.uid and \n"
			+ "t.business_type_id=b.business_type_id and bm.business_id=b.business_id and t.user_id=? and \n"
			+ "bm.business_name=? and t.payment_date= ? group by t.plan_amount,b.business_type,u.username,bm.business_name,t.payment_date";


	static String GET_BUSINESSES_TYPES_BY_DAY ="select t.plan_amount,t.mobile_number,b.business_type,u.username,bm.business_name,t.payment_date\n"
			+ "from Al399_transactions_table as t join Al399_business_type_table as b \n"
			+ "join Al399_user_details as u  join Al399_business_master_table as bm where t.user_id=u.uid and \n"
			+ "t.business_type_id=b.business_type_id and bm.business_id=b.business_id and t.user_id=? and \n"
			+ "bm.business_name=? and b.business_type=? and t.payment_date=? group by t.plan_amount,t.mobile_number,b.business_type,u.username,bm.business_name,t.payment_date";


	static String GET_BUSINESSES_BY_YEAR ="select count(*),t.plan_amount,b.business_type,u.username,bm.business_name,t.payment_date\n"
			+ "from Al399_transactions_table as t join Al399_business_type_table as b \n"
			+ "join Al399_user_details as u  join Al399_business_master_table as bm where t.user_id=u.uid and \n"
			+ "t.business_type_id=b.business_type_id and bm.business_id=b.business_id and t.user_id=? and \n"
			+ "bm.business_name=? and date_format(t.payment_date,'%Y')=? group by t.plan_amount,b.business_type,u.username,bm.business_name,t.payment_date";


	static String GET_BUSINESSES_TYPES_BY_YEAR ="select t.plan_amount,b.business_type,u.username,bm.business_name,t.payment_date\n"
			+ "from Al399_transactions_table as t join Al399_business_type_table as b \n"
			+ "join Al399_user_details as u  join Al399_business_master_table as bm where t.user_id=u.uid and \n"
			+ "t.business_type_id=b.business_type_id and bm.business_id=b.business_id and t.user_id=? and \n"
			+ "bm.business_name=? and b.business_type=? and date_format(t.payment_date,'%Y')=? group by t.plan_amount,b.business_type,u.username,bm.business_name,t.payment_date";

	
	static String GET_BUSINESSES_BY_MONTH ="select count(*),t.plan_amount,t.mobile_number,b.business_type,u.username,bm.business_name,t.payment_date\n"
			+ "from Al399_transactions_table as t join Al399_business_type_table as b \n"
			+ "join Al399_user_details as u  join Al399_business_master_table as bm where t.user_id=u.uid and \n"
			+ "t.business_type_id=b.business_type_id and bm.business_id=b.business_id and t.user_id=? and \n"
			+ "bm.business_name=? and date_format(t.payment_date,'%Y-%m')=? group by t.plan_amount,t.mobile_number,b.business_type,u.username,bm.business_name,t.payment_date";


	static String GET_BUSINESSES_TYPES_BY_MONTH ="select t.plan_amount,t.mobile_number,b.business_type,u.username,bm.business_name,t.payment_date\n"
			+ "from Al399_transactions_table as t join Al399_business_type_table as b \n"
			+ "join Al399_user_details as u  join Al399_business_master_table as bm where t.user_id=u.uid and \n"
			+ "t.business_type_id=b.business_type_id and bm.business_id=b.business_id and t.user_id=? and \n"
			+ "bm.business_name=? and b.business_type=? and date_format(t.payment_date,'%Y-%m')=? group by t.plan_amount,t.mobile_number,b.business_type,u.username,bm.business_name,t.payment_date";

}


