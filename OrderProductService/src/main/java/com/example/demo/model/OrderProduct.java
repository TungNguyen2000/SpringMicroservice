package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(OrderProduct.class)
@Table(name="`Order_Product`")
public class OrderProduct implements Serializable{

	@Id
	@Column(name ="OrderID")
	private int OrderId;
	@Column(name = "DonGia", nullable = true)
	private double DonGia;
	@Column(name = "SoLuong", nullable = true)
	private int SoLuong;
	@Id
	@Column(name = "ProductID")
	private int ProductID;
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public double getDonGia() {
		return DonGia;
	}
	public void setDonGia(double donGia) {
		DonGia = donGia;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public int getProductID() {
		return ProductID;
	}
	public void setProductID(int productID) {
		ProductID = productID;
	}
	
	
}
