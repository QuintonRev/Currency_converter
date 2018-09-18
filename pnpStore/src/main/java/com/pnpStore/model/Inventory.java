package com.pnpStore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productInventory")
public class Inventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int inventory_id;
	private int product_quantity;  
	private String product_name;
	public Inventory() {
		super();
	}
	public Inventory(int inventory_id, int product_quantity, String product_name) {
		super();
		this.inventory_id = inventory_id;
		this.product_quantity = product_quantity;		
		this.product_name = product_name;
	}
	public int getInventory_id() {
		return inventory_id;
	}
	public void setInventory_id(int inventory_id) {
		this.inventory_id = inventory_id;
	}
	public int getProduct_quantity() {
		return product_quantity;
	}
	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}
	
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	
	
	

}
