package dev.Innocent.Repository;

import dev.Innocent.Model.Book;
import dev.Innocent.Model.Issued;
import dev.Innocent.Model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssuedRepository extends JpaRepository<Issued, Long> {

    public List<Issued> findByReturned(Integer returned);

    public Long countByMemberAndReturned(Member member, Integer returned);

}
