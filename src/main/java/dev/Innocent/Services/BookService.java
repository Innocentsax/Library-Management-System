package dev.Innocent.Services;

import dev.Innocent.Model.Book;
import dev.Innocent.Model.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {

    long getTotalCount();

    List<Book> getAll();

    Long getTotalIssuedBooks();

    Book getBookById(Long id);

    Book getBookByTag(String tag);

    List<Book> getBookByIds(List<Long> ids);

    List<Book> getByCategory(Category category);

    List<Book> getAvailableByCategory(Category category);

    Book addNewBook(Book book);

    Book save(Book book);

    void deleteBook(Long id);

    void deleteBook(Book book);

    boolean hasUsage(Book book);
}
