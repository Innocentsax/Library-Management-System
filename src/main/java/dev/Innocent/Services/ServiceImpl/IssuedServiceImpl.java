package dev.Innocent.Services.ServiceImpl;

import dev.Innocent.Model.Issued;
import dev.Innocent.Model.Member;
import dev.Innocent.Repository.IssuedRepository;
import dev.Innocent.Services.IssuedService;
import dev.Innocent.Utils.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class IssuedServiceImpl implements IssuedService {
    private IssuedRepository issuedRepository;

    @Autowired
    public IssuedServiceImpl(IssuedRepository issuedRepository) {
        this.issuedRepository = issuedRepository;
    }

    @Override
    public Long getCountByMember(Member member) {
        return issuedRepository.countByMemberAndReturned(member, Constants.BOOK_NOT_RETURNED);
    }

    @Override
    public List<Issued> getAll() {
        return issuedRepository.findAll();
    }

    @Override
    public Issued getIssuedBookById(Long id) {
        return issuedRepository.findById(id).get();
    }

    @Override
    public List<Issued> getAllUnreturned() {
        return issuedRepository.findByReturned( Constants.BOOK_NOT_RETURNED );
    }

    @Override
    public Issued addNewIssuedBook(Issued issued) {
        issued.setIssuedDate( new Date() );
        issued.setReturned( Constants.BOOK_NOT_RETURNED );
        return issuedRepository.save(issued);
    }

    @Override
    public Issued save(Issued issued) {
        return issuedRepository.save(issued);
    }

    @Override
    public void deleteIssuedBook(Long id) {
        issuedRepository.deleteById(id);
    }
}
