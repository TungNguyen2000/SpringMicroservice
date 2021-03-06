package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`order`")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="OrderId")
	private int OrderId;
	@Column(name = "TotalPrice", nullable = true)
	private double TotalPrice;
	@Column(name = "OrderStatus", nullable = true)
	private String OrderStatus;
	@Column(name = "CreatedOn", nullable = true)
	private Date CreatedOn = new Date();
	@Column(name = "CustomerID")
	private int CustomerID;
	@Column(name = "EmployeeID", nullable = true)
	private int EmployeeID;
	
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public double getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		TotalPrice = totalPrice;
	}
	
	public String getOrderStatus() {
		return OrderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		OrderStatus = orderStatus;
	}
	public Date getCreatedOn() {
		return CreatedOn;
	}
	public void setCreatedOn(Date createdOn) {
		CreatedOn = createdOn;
	}
	public int getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}
	public int getEmployeeID() {
		return EmployeeID;
	}
	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}
	
	
}
