package com.example.productapp.controller;

import com.example.productapp.model.Product;
import com.example.productapp.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ykoer on 9/25/17.
 */
@RestController
class ProductController {

	@Autowired
	private ProductRepository repository;

	@RequestMapping(
			value = "/product",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public List<Product> getProducts(){
		return repository.findAll();
	}

	@RequestMapping(
			value = "/product/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<Product> getProductById(@PathVariable String id){
		Product product = repository.findOne(id);
		return new ResponseEntity<Product>(product, product!=null?HttpStatus.OK:HttpStatus.NOT_FOUND);
	}

	@RequestMapping(
			value = "/product",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE
	)
	public void createProduct(@RequestBody Product product){
		repository.save(product);
	}

	@RequestMapping(
			value = "/product/{id}",
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE
	)
	public void updateProduct(@RequestBody Product product){
		repository.save(product);
	}

	@RequestMapping(
			value = "/product/{id}",
			method = RequestMethod.DELETE
	)
	public void createProduct(@PathVariable String id){
		repository.delete(id);
	}
}
