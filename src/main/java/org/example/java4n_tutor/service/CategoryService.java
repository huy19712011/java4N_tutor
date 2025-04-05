package org.example.java4n_tutor.service;

import org.example.java4n_tutor.entity.Category;
import org.example.java4n_tutor.repository.CategoryRepository;

import java.util.List;

public class CategoryService {

    CategoryRepository categoryRepository = new CategoryRepository();

    public List<Category> getCategories() {

        return categoryRepository.getCategories();
    }

    public Category getCategoryById(long id) {

        return categoryRepository.getCategoryById(id);
    }
}
