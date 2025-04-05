package org.example.java4n_tutor.service;

import org.example.java4n_tutor.entity.Product;
import org.example.java4n_tutor.repository.ProductRepository;

import java.util.List;

public class ProductService {

    private ProductRepository productRepository = new ProductRepository();

    public List<Product> getProducts() {

        return productRepository.getProducts();
    }

    public void addProduct(Product product) {

        productRepository.addProduct(product);
    }

    public Product getProductById(Long id) {

        return productRepository.getProductById(id);
    }

    public void updateProduct(Product product) {

        productRepository.updateProduct(product);
    }

    public void deleteProduct(Long id) {

        productRepository.deleteProduct(id);
    }
}
