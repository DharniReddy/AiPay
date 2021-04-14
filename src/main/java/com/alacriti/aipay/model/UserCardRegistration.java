package com.alacriti.aipay.model;

public class UserCardRegistration {
	
//	private int card_id;
//	private int user_id; //foreign key
//	private long card_number;
//	private String card_holder_name;
//	private String card_type;
//	private String card_expiry_date;
//	
	private int cardId;
	private int userId; //foreign key
	private long cardNumber;
	private String cardHolderName;
	private String cardType;
	private String cardExpiryDate;
	
	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardExpiryDate() {
		return cardExpiryDate;
	}
	public void setCardExpiryDate(String cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}
	
}
