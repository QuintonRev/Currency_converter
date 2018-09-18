package com.pnpStore.model;

import javax.persistence.Entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cart_id;
	public Cart() {
		super();
	}
	public Cart(int cart_id, int user_id, int order_no, int cart_quantity, String product_name, double cart_price,
			String product_img, int product_id) {
		super();
		this.cart_id = cart_id;
		this.user_id = user_id;
		this.order_no = order_no;
		this.cart_quantity = cart_quantity;
		this.product_name = product_name;
		this.cart_price = cart_price;
		this.product_img = product_img;
		this.product_id = product_id;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getOrder_no() {
		return order_no;
	}
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	public int getCart_quantity() {
		return cart_quantity;
	}
	public void setCart_quantity(int cart_quantity) {
		this.cart_quantity = cart_quantity;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getCart_price() {
		return cart_price;
	}
	public void setCart_price(double cart_price) {
		this.cart_price = cart_price;
	}
	public String getProduct_img() {
		return product_img;
	}
	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}
	private int user_id;
	private int order_no;
	private int cart_quantity;
	private String product_name;
	private double cart_price;
	private String product_img;
	private int product_id;
	
	
	
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

}
