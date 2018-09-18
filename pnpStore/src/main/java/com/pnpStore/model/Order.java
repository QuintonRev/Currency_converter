package com.pnpStore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productOrder")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int order_id;
	public Order() {
		super();
	}

	
	public Order(int order_id, int user_id, int userNo, String user_address, String user_location) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		this.userNo = userNo;
		this.user_address = user_address;
		this.user_location = user_location;
	}


	private int user_id;
	private int userNo;
	private String user_address;
	private String user_location;
	
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public String getUser_location() {
		return user_location;
	}
	public void setUser_location(String user_location) {
		this.user_location = user_location;
	}
	
	
}
