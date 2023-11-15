package dev.Innocent.Services;

import dev.Innocent.Model.Book;
import dev.Innocent.Model.Member;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MemberService {

    Long getTotalCount();

    ResponseEntity<?> getAllMembers();

    Long getStudentCount();

    List<Member> getAll();

    Member getMemberById(Long id);

    Member addNewMember(Member member);

    Member saveMember(Member member);

    void deleteMember(Long id);

    void deleteMember(Member member);

    Long getStudentsCount();

    boolean hasUsage(Member member);

}
