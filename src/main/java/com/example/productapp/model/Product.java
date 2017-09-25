package com.example.productapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
public class Product {

    @Id
    public String id;

    public String name;
    public String description;
    public String category;


    public Product() {}

    public Product(String name, String description, String category) {
        this.name = name;
        this.description = description;
        this.category = category;
    }

    @Override
    public String toString() {
        return String.format(
                "Product[id=%s, name='%s', description='%s', category='%s']",
                id, name, description, category);
    }

}