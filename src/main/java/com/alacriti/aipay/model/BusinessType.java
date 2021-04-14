package com.alacriti.aipay.model;

public class BusinessType {
	
	private int businessTypeId;
	private int businessId;
	private String businessType;
	private String businessName;
	private int amount;
	private String plan;
	
	
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public int getBusinessTypeId() {
		return businessTypeId;
	}
	public void setBusinessTypeId(int businessTypeId) {
		this.businessTypeId = businessTypeId;
	}
	public int getBusinessId() {
		return businessId;
	}
	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}
	public String getBusinessType() {
		return businessType;
	}
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
