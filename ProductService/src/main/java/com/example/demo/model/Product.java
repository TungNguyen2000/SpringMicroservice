package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`Product`")
public class Product {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="ProductId")
	private int ProductId;
	@Column(name = "Price", nullable = true)
	private double Price;
	@Column(name = "ProductImage", nullable = true)
	private String ProductImage;
	@Column(name = "ProductName", nullable = true)
	private String ProductName;
	@Column(name = "ProductTypeID")
	private int ProductTypeID;
	@Column(name = "Soluong", nullable = true)
	private int Soluong;
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		ProductId = productId;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public String getProductImage() {
		return ProductImage;
	}
	public void setProductImage(String productImage) {
		ProductImage = productImage;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public int getProductTypeID() {
		return ProductTypeID;
	}
	public void setProductTypeID(int productTypeID) {
		ProductTypeID = productTypeID;
	}
	public int getSoluong() {
		return Soluong;
	}
	public void setSoluong(int soluong) {
		Soluong = soluong;
	}
	
	
}
