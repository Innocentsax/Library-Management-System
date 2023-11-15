package dev.Innocent.Services.ServiceImpl;

import dev.Innocent.Model.Book;
import dev.Innocent.Model.Category;
import dev.Innocent.Repository.BookRepository;
import dev.Innocent.Services.BookService;
import dev.Innocent.Services.IssuedBookService;
import dev.Innocent.Utils.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private IssuedBookService issuedBookService;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, IssuedBookService issuedBookService) {
        this.bookRepository = bookRepository;
        this.issuedBookService = issuedBookService;
    }

    @Override
    public long getTotalCount() {
        return bookRepository.count();
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Long getTotalIssuedBooks() {
        return bookRepository.countByStatus(Constants.BOOK_STATUS_ISSUED);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public Book getBookByTag(String tag) {
        return bookRepository.findByTag(tag);
    }

    @Override
    public List<Book> getBookByIds(List<Long> ids) {
        return bookRepository.findAllById(ids);
    }

    @Override
    public List<Book> getByCategory(Category category) {
        return bookRepository.findByCategory(category);
    }

    @Override
    public List<Book> getAvailableByCategory(Category category) {
        return bookRepository.findByCategoryAndStatus(category, Constants.BOOK_STATUS_AVAILABLE);
    }

    @Override
    public Book addNewBook(Book book) {
        book.setCreatedDate(new Date());
        book.setStatus(Constants.BOOK_STATUS_AVAILABLE);
        return bookRepository.save(book);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public boolean hasUsage(Book book) {
        return issuedBookService.getCountByBook(book)>0;
    }
}
