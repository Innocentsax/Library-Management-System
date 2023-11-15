package dev.Innocent.Services;

import dev.Innocent.Model.IssuedBook;

import java.util.List;

public interface IssuedBookService {

    List<IssuedBook> getAll();

    IssuedBook getIssuedBookById(Long id);

    IssuedBook addNewIssuedBook(IssuedBook issuedBook);

    IssuedBook save(IssuedBook issuedBook);

//    ResponseEntity<?> getCountByBook(Book book);

    int getCountByBook(dev.Innocent.Model.Book book);
}
