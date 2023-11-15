package dev.Innocent.Controller;

import dev.Innocent.Model.Book;
import dev.Innocent.Services.BookService;
import dev.Innocent.Services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookService bookService;
    private CategoryService categoryService;

    @Autowired
    public BookController(BookService bookService, CategoryService categoryService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAll();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/add")
    public ResponseEntity<Book> addBookPage() {
        return ResponseEntity.ok(new Book());
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<Book> editBookPage(@PathVariable(name = "id") Long id) {
        Book book = bookService.getBookById(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveBook(@Valid @RequestBody Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Invalid book data");
        }

        if (book.getId() == null) {
            if (bookService.getBookByTag(book.getTag()) != null) {
                return ResponseEntity.badRequest().body("Tag already exists");
            } else {
                bookService.addNewBook(book);
                return ResponseEntity.ok("'" + book.getTitle() + "' is added as a new Book.");
            }
        } else {
            Book updatedBook = bookService.save(book);
            return ResponseEntity.ok("Changes for '" + book.getTitle() + "' are saved successfully.");
        }
    }

    @GetMapping("/remove/{id}")
    public ResponseEntity<String> removeBook(@PathVariable(name = "id") Long id) {
        Book book = bookService.getBookById(id);
        if (book != null) {
            if (bookService.hasUsage(book)) {
                return ResponseEntity.badRequest().body("Book is in use");
            } else {
                bookService.deleteBook(id);
            }
        }
        return ResponseEntity.ok("Book removed successfully");
    }


}
