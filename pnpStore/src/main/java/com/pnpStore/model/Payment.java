package com.pnpStore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {	

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int payment_id;
	private String bank_name;
	private String bank_type;
    private String card_number;
    private String amount_payable;
	private int user_id;
    private int order_id;
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getBank_type() {
		return bank_type;
	}
	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
	}
	public String getCard_number() {
		return card_number;
	}
	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}
	public String getAmount_payable() {
		return amount_payable;
	}
	public void setAmount_payable(String amount_payable) {
		this.amount_payable = amount_payable;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public Payment(int payment_id, String bank_name, String bank_type, String card_number, String amount_payable,
			int user_id, int order_id) {
		super();
		this.payment_id = payment_id;
		this.bank_name = bank_name;
		this.bank_type = bank_type;
		this.card_number = card_number;
		this.amount_payable = amount_payable;
		this.user_id = user_id;
		this.order_id = order_id;
	}
	public Payment() {
		super();
	}
    
  
  
  
  }