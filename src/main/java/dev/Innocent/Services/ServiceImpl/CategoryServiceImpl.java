package dev.Innocent.Services.ServiceImpl;

import dev.Innocent.Model.Category;
import dev.Innocent.Repository.CategoryRepository;
import dev.Innocent.Services.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {


    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public long getTotalCount() {
        return categoryRepository.count();
    }

    @Override
    public List<Category> getAllBySort() {
        return categoryRepository.findAllByOrderByNameAsc();
    }

    @Override
    public Category getById(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Category addNewCategory(Category category) {
        category.setCreatedDate(new Date());
        return categoryRepository.save(category);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void deleteCategory(Category category) {
        categoryRepository.delete(category);
    }

    @Override
    public boolean hasUsage(Category category) {
        return category.getBooks().size()>0;
    }
}
