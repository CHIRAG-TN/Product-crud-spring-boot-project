package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.PutExchange;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import java.util.List;

@RestController
public class ProductController {
	
	
	
	@Autowired
	ProductService service;
	
	@GetMapping("/product")
	public List<Product> getProduct(){
		return service.getProduct();
	}
	
	@PostMapping("/product")
	public void postproduct(@RequestBody Product prod1) {
		service.postProduct(prod1);
	}
	
	@PutMapping("/product")
	public void putProduct(@RequestBody Product prod1) {
		service.putProduct(prod1);
	}
	
	@DeleteMapping("/product/{prodId}")
	public void deleteProduct(@PathVariable int prodId) {
		service.deleteProduct(prodId);
	}

}
