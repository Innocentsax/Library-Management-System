package dev.Innocent.Services.ServiceImpl;

import dev.Innocent.Model.IssuedBook;
import dev.Innocent.Repository.IssuedBookRepository;
import dev.Innocent.Services.IssuedBookService;
import dev.Innocent.Utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class IssuedBookServiceImpl implements IssuedBookService {

    private IssuedBookRepository issuedBookRepository;

    @Autowired
    public IssuedBookServiceImpl(IssuedBookRepository issuedBookRepository) {
        this.issuedBookRepository = issuedBookRepository;
    }

    @Override
    public List<IssuedBook> getAll() {
        return issuedBookRepository.findAll();
    }

    @Override
    public IssuedBook getIssuedBookById(Long id) {
        return issuedBookRepository.findById(id).get();
    }

    @Override
    public IssuedBook addNewIssuedBook(IssuedBook issuedBook) {
        issuedBook.setReturned( Constants.BOOK_NOT_RETURNED );
        return issuedBookRepository.save(issuedBook);
    }

    @Override
    public IssuedBook save(IssuedBook issuedBook) {
        return issuedBookRepository.save(issuedBook);
    }

//    @Override
//    public Long getCountByBook(Book book) {
//        return issuedBookRepository.countByMemberAndReturned(book, Constants.BOOK_NOT_RETURNED);
//    }

    @Override
    public int getCountByBook(dev.Innocent.Model.Book book) {
        return 0;
    }
}
