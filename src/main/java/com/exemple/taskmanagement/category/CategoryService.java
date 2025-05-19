package com.exemple.taskmanagement.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(String name, String description){
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        category.setAtivo(1);

        return categoryRepository.save(category);
    }

    public List<Category> listCategoriesAtivos() {
        return categoryRepository.findByAtivo(1);
    }

    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }

    public List<Object[]> countTaskCategory() {
        return categoryRepository.countTaskCategory();
    }

    public void removeCategories(Long id) {
        Category category = CategoryService.this.categoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));
        category.setAtivo(0);
        categoryRepository.save(category);
    }

}
