package com.pnpStore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {	

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int product_id;
	private String product_name;
	private String product_group;
	private double product_price;
	private String product_img;
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_group() {
		return product_group;
	}
	public void setProduct_group(String product_group) {
		this.product_group = product_group;
	}
	public double getProduct_price() {
		return product_price;
	}
	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}
	public String getProduct_img() {
		return product_img;
	}
	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}
	public Product(int product_id, String product_name, String product_group, double product_price,
			String product_img) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_group = product_group;
		this.product_price = product_price;
		this.product_img = product_img;
	}
	public Product() {
		super();
	}
	
	
}