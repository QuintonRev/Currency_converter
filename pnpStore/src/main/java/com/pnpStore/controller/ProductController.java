package com.pnpStore.controller;

//import ProductController used files
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import com.pnpStore.service.ProductService;
import com.pnpStore.model.Product;

//@RestController - indicates that it is a  Spring MVC controller using REST API
@RestController
public class ProductController {
	
	//@Autowired - uses properties to get rid of setter methods
	@Autowired
	private ProductService productService;
	
	//RequestMapping - maps the specified URL eg '/GetProducts'
	@RequestMapping("/GetProducts")
	//Generic array list
	public List<Product> getAllproducts() 
	{
		return productService.getAllproducts();
	}
	
	//RequestMapping - maps the specified URL eg '/DeleteProduct/{productID}'
	//RequestMethod = request method type - DELETE it removes specific resources using a certain ID
	@RequestMapping(method = RequestMethod.DELETE,value = "/DeleteProduct/{productID}")
	//@PathVariable - identifies the path pattern used in URL for incoming data
	public void DeleteProduct(@PathVariable int productID)
	{
		productService.DeleteProduct(productID);

	}
	
	//RequestMapping - maps the specified URL eg '/SaveProduct'
	//RequestMethod = request method type - POST it inserts specific resources
	@RequestMapping(method = RequestMethod.POST,value = "/SaveProduct")
	//@RequestBody converts JSON format to java object
	public void SaveProduct(@RequestBody Product Products)
	{
		productService.SaveProduct(Products);		

	}
	
	//RequestMapping - maps the specified URL eg '/UpdateProduct/{id}'
	//RequestMethod = request method type - PUT it updates specific resources using a certain ID
	@RequestMapping(method = RequestMethod.PUT,value = "/UpdateProduct/{id}")
	//@RequestBody converts JSON format to java object
	//@PathVariable - identifies the path pattern used in URL for incoming data
	public void updateProduct(@RequestBody Product Products, @PathVariable int id)
	{
		
		productService.updateProduct(id, Products);
		
	}

}
