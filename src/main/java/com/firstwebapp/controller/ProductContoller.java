package com.firstwebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.firstwebapp.dto.Product;
import com.firstwebapp.service.ProductService;

@RestController
public class ProductContoller {

	@Autowired
	ProductService productService;

	@GetMapping("/productDetails")
	private List<Product> getProducts() {
		return productService.getProducts();
	}
	
	@GetMapping("/productDetails/{productId}")
	private Product getProductById(@PathVariable int productId) {
		return productService.getProductById(productId);
	}
}
