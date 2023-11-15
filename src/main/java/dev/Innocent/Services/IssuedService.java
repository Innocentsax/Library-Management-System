package dev.Innocent.Services;

import dev.Innocent.Model.Issued;
import dev.Innocent.Model.Member;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IssuedService {
    Long getCountByMember(Member member);

    List<Issued> getAll();

    Issued getIssuedBookById(Long id);

    List<Issued> getAllUnreturned();

    Issued addNewIssuedBook(Issued issued);

    Issued save(Issued issued);

   void deleteIssuedBook(Long id);

}
