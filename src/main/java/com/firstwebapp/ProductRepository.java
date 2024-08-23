package com.firstwebapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firstwebapp.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>  {

}
