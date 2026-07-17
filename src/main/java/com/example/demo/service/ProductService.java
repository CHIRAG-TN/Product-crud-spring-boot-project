package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.repository.Productrepo;

@Service
public class ProductService {
	
	private final Logger log=LogManager.getLogger(ProductService.class);
	
	@Autowired
	private Productrepo repo;
	
	public List<Product> getProduct() {
		
		log.info("Before getting products");
		List<Product> prod=repo.findAll();
		
		if(prod.isEmpty()) {
			throw new ProductNotFoundException("No products in database");
		}
		return prod;
		
	}

	public void postProduct( Product prod1) {

		repo.save(prod1);
	}

	
	public void deleteProduct(int prodId) {

		if(repo.findById(prodId).isEmpty()) {
			throw new ProductNotFoundException("No product in database to delete");
		}
		repo.deleteById(prodId);;
	}

	public void putProduct(Product prod1) {

		repo.save(prod1);
	}
	
	
	
	
	

}
