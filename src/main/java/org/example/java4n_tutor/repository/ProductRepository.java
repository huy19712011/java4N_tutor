package org.example.java4n_tutor.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.java4n_tutor.entity.Product;

import java.util.List;

public class ProductRepository {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    EntityManager em = emf.createEntityManager();

    public List<Product> getProducts() {

        return em.createQuery("SELECT p from Product p", Product.class).getResultList();
    }
}
