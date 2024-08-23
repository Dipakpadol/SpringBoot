package com.firstwebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.firstwebapp.ProductRepository;
import com.firstwebapp.entity.Product;
import com.firstwebapp.exception.ProductNotFoundException;

@RestController
public class ProductContoller {

//	@Autowired
//	ProductRepository productRepository;
	
	private final ProductRepository productRepository;

	public ProductContoller(ProductRepository productRepository) {
	super();
	this.productRepository = productRepository;
}

	@GetMapping("/productDetails")
	private List<Product> getProducts() {
		return productRepository.findAll();
	}
	
	@GetMapping("/productDetails/{productId}")
	private Product getProductById(@PathVariable int productId) {
		return productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException(productId));
	}
	
	@PostMapping("/setProduct")
	private String setProduct(@RequestBody Product product) {
		productRepository.save(product);
		return "Product Insert Successfully!";
	}
	
	@PostMapping("/setProducts")
	private String setProducts(@RequestBody List<Product> product) {
		productRepository.saveAll(product);
		return "Products Insert Successfully!";
	}
	
	@PutMapping("/updateProduct/{productId}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product newProduct, @PathVariable int productId) {
	    return productRepository.findById(productId)
	        .map(existingProduct -> {
	            // Update existing product's details with new product's details
	            existingProduct.setProductName(newProduct.getProductName());
	            existingProduct.setProductPrice(newProduct.getProductPrice());
	            
	            // Save updated product to the repository
	            Product updatedProduct = productRepository.save(existingProduct);
	            return ResponseEntity.ok(updatedProduct);
	        })
	        .orElseGet(() -> {
	            // If product doesn't exist, set the new product's ID
	            newProduct.setProductId(productId);
	            
	            // Save new product to the repository
	            Product savedProduct = productRepository.save(newProduct);
	            return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
	        });
	}
	
	@DeleteMapping("/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable int productId) {
		productRepository.deleteById(productId);
		return "Product deleted Successfully!";
		
	}

}
