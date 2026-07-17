package com.example.demo.model;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Component
@Entity
public class Product{

	@Id
	private int productId;
	@NotEmpty
	private String productName;
	private int productprice;
	private String ram;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductprice() {
		return productprice;
	}
	public void setProductprice(int productprice) {
		this.productprice = productprice;
	}
	public Product(int productId, String productName, int productprice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productprice = productprice;
	}
	
	public Product() {
		
	}
	
	
}
