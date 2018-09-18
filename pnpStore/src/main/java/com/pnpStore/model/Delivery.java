package com.pnpStore.model;





import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "delivery")
public class Delivery {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int delivery_id;
	private int order_id;	
	private String delivery_date;
	private String delivery_time;
	private String delivery_status;
	public Delivery() {
		super();
	}
	public Delivery(int delivery_id, int order_id, String delivery_date, String delivery_time, String delivery_status) {
		super();
		this.delivery_id = delivery_id;
		this.order_id = order_id;
		this.delivery_date = delivery_date;
		this.delivery_time = delivery_time;
		this.delivery_status = delivery_status;
	}
	public int getDelivery_id() {
		return delivery_id;
	}
	public void setDelivery_id(int delivery_id) {
		this.delivery_id = delivery_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getDelivery_date() {
		return delivery_date;
	}
	public void setDelivery_date(String delivery_date) {
		this.delivery_date = delivery_date;
	}
	public String getDelivery_time() {
		return delivery_time;
	}
	public void setDelivery_time(String delivery_time) {
		this.delivery_time = delivery_time;
	}
	public String getDelivery_status() {
		return delivery_status;
	}
	public void setDelivery_status(String delivery_status) {
		this.delivery_status = delivery_status;
	}
	
	
	
}
