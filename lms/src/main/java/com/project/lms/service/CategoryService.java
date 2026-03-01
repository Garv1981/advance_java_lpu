package com.project.lms.service;


import com.project.lms.entity.Category;
import java.util.List;

public interface CategoryService {

    Category addCategory(Category category);

    List<Category> getAllCategories();

    Category getCategoryById(Long id);
}