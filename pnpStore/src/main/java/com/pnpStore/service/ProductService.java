package com.pnpStore.service;

//import ProductService used files
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pnpStore.model.Product;
import com.pnpStore.repository.ProductRepository;


//@Services - creates a services bean , has all business logic and calls methods from ProductRepository
@Service
public class ProductService {

	//@Autowired - uses properties to get rid of setter methods 
	@Autowired
	public ProductRepository productRepository;
	
	public List<Product> getAllproducts()
	{
		
		List<Product> products = new ArrayList<>();
		productRepository.findAll()
		.forEach(products::add);
		return products;
		
	}
	
	//delete Product
	public void DeleteProduct(int productID) {
		
		
		productRepository.delete(productID);
		
	}
	
	//Add Product
	public void SaveProduct(Product Products) {
		
		
		productRepository.save(Products);
		
	}
	//update Product using product id
	public void updateProduct(int id, Product Products) {
		
		
		productRepository.save(Products);
		
	}
}
