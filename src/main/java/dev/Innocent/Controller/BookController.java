package dev.Innocent.Controller;

import dev.Innocent.Model.Category;
import dev.Innocent.Services.BookService;
import dev.Innocent.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Book")
public class BookController {

    private BookService bookService;
    private CategoryService categoryService;

    @Autowired
    public BookController(BookService bookService, CategoryService categoryService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    @RequestMapping("/getBooks")
    public List<Category> getBooks() {
        return categoryService.getAllBySort();
    }

    @RequestMapping(value = "/getBooksByCategory", method = RequestMethod.GET)
    public List<Category> getBooksByCategory(Long id) {
        return categoryService.getAllBySort();
    }

    @RequestMapping(value = "/getBooksByTag", method = RequestMethod.GET)
    public List<Category> getBooksByTag(String tag) {
        return categoryService.getAllBySort();
    }


}
