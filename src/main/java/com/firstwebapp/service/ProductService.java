package com.firstwebapp.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.firstwebapp.dto.Product;

@Service
public class ProductService {
	
	List<Product> productList = Arrays.asList(new Product(101, "Fan", 500), new Product(102, "Refrigerator", 15000), new Product(103, "Television", 10000));
	
	public List<Product> getProducts() {		
		return productList;
	}
	
//	public Product getProductById(int productId) {
//		
//		return productList.stream().filter(s -> s.getProductId() == productId).findFirst().
//		
//	}
}