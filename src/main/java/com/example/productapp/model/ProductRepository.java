package com.example.productapp.model;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {

    public Product findByName(String firstName);
    public List<Product> findByCategory(String lastName);

}