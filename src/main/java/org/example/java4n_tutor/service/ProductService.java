package org.example.java4n_tutor.service;

import org.example.java4n_tutor.entity.Product;
import org.example.java4n_tutor.repository.ProductRepository;

import java.util.List;

public class ProductService {

    private ProductRepository productRepository = new ProductRepository();

    public List<Product> getProducts() {

        return productRepository.getProducts();
    }
}
