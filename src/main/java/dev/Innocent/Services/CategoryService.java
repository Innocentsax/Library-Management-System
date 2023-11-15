package dev.Innocent.Services;

import dev.Innocent.Model.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {

    List<Category> getAll();

    long getTotalCount();

    List<Category> getAllBySort();

    Category getById(Long id);

    Category addNewCategory(Category category);

    Category save(Category category);

   void deleteCategory(Long id);

    void deleteCategory(Category category);

    boolean hasUsage(Category category);
}
