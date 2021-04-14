package com.alacriti.aipay.model;

public class TransactionDetails {
	
	private String userName;
	private Long cardNumber;
	private String BusinessName;
	private String BusinessType;
	private Long MobileNumber;
	private int planAmount;
	private String paymentDate;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
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
	public Long getMobileNumber() {
		return MobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		MobileNumber = mobileNumber;
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
	
}
  