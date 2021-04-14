package com.alacriti.aipay.model;

public class Transactions {
	
	private int transactionId;
	private int userId;
	private int cardId;
	private int businessTypeId;
	private Long mobileNumber;
	private int planAmount ;
	private int favourite ;
	
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	public int getBusinessTypeId() {
		return businessTypeId;
	}
	public void setBusinessTypeId(int businessTypeId) {
		this.businessTypeId = businessTypeId;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public int getPlanAmount() {
		return planAmount;
	}
	public void setPlanAmount(int planAmount) {
		this.planAmount = planAmount;
	}
	public int getFavourite() {
		return favourite;
	}
	public void setFavourite(int favourite) {
		this.favourite = favourite;
	}
	
	

}
