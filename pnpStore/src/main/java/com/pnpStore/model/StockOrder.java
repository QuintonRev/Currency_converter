package com.pnpStore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stockOrder")
public class StockOrder {	

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stockOrder_id;
	private String stock_product_name;
	private String stock_product_group;
	private int stock_product_quantity;
	private String stock_product_img;
    private String stockOrder_status;
	public int getStockOrder_id() {
		return stockOrder_id;
	}
	public void setStockOrder_id(int stockOrder_id) {
		this.stockOrder_id = stockOrder_id;
	}
	public String getStock_product_name() {
		return stock_product_name;
	}
	public void setStock_product_name(String stock_product_name) {
		this.stock_product_name = stock_product_name;
	}
	public String getStock_product_group() {
		return stock_product_group;
	}
	public void setStock_product_group(String stock_product_group) {
		this.stock_product_group = stock_product_group;
	}
	public int getStock_product_quantity() {
		return stock_product_quantity;
	}
	public void setStock_product_quantity(int stock_product_quantity) {
		this.stock_product_quantity = stock_product_quantity;
	}
	public String getStock_product_img() {
		return stock_product_img;
	}
	public void setStock_product_img(String stock_product_img) {
		this.stock_product_img = stock_product_img;
	}
	public String getStockOrder_status() {
		return stockOrder_status;
	}
	public void setStockOrder_status(String stockOrder_status) {
		this.stockOrder_status = stockOrder_status;
	}
	public StockOrder(int stockOrder_id, String stock_product_name, String stock_product_group,
			int stock_product_quantity, String stock_product_img, String stockOrder_status) {
		super();
		this.stockOrder_id = stockOrder_id;
		this.stock_product_name = stock_product_name;
		this.stock_product_group = stock_product_group;
		this.stock_product_quantity = stock_product_quantity;
		this.stock_product_img = stock_product_img;
		this.stockOrder_status = stockOrder_status;
	}
	public StockOrder() {
		super();
	}
    
    
    
}