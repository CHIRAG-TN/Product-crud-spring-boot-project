package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.repository.Productrepo;

@Service
public class ProductService {
	
	@Autowired
	private Productrepo repo;
	
	
	public List<Product> getProduct() {
		
		if(repo.findAll().isEmpty()) {
			throw new ProductNotFoundException("No products in database");
		}
		return repo.findAll();
		
	}

	public void postProduct(Product prod1) {

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
