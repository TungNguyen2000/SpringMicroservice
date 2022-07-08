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
@Table(name="`Comment`")
public class Comment {

	@Id
	@Column(name ="CommentID")
	private int CommentId;
	@Column(name = "CustomerID", nullable = true)
	private int CustomerID;
	@Column(name = "ProductID", nullable = true)
	private int ProductID;
	@Column(name = "Content", nullable = false)
	private String Content;
	public int getCommentId() {
		return CommentId;
	}
	public void setCommentId(int commentId) {
		CommentId = commentId;
	}
	public int getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}
	public int getProductID() {
		return ProductID;
	}
	public void setProductID(int productID) {
		ProductID = productID;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	
	
}
