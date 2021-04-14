package com.alacriti.aipay.model;

public class TransactionHistory {
	
	private String userName;
	private String BusinessName;
	private String BusinessType;
	private int planAmount;
	private String paymentDate;
	private int count;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBusinessName() {
		return BusinessName;
	}
	public void setBusinessName(String businessName) {
		BusinessName = businessName;
	}
	public String getBusinessType() {
		return BusinessType;
	}
	public void setBusinessType(String businessType) {
		BusinessType = businessType;
	}
	public int getPlanAmount() {
		return planAmount;
	}
	public void setPlanAmount(int planAmount) {
		this.planAmount = planAmount;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
