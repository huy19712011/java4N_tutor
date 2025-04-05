package org.example.java4n_tutor.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.java4n_tutor.entity.Category;

import java.util.List;

public class CategoryRepository {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    EntityManager em = emf.createEntityManager();

    public List<Category> getCategories() {

        return em.createQuery("select c from Category c", Category.class).getResultList();
    }

    public Category getCategoryById(Long id) {

        return em.find(Category.class, id);
    }
}
