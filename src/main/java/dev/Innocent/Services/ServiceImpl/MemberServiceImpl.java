package dev.Innocent.Services.ServiceImpl;

import dev.Innocent.Model.Member;
import dev.Innocent.Repository.MemberRepository;
import dev.Innocent.Services.MemberService;
import dev.Innocent.Utils.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Long getTotalCount() {
        return memberRepository.count();
    }

    @Override
    public ResponseEntity<?> getAllMembers() {
        return null;
    }

    @Override
    public Long getStudentCount() {
        return memberRepository.countByType(Constants.MEMBER_STUDENT);
    }

    @Override
    public List<Member> getAll() {
        return memberRepository.findAllByOrderByFirstNameAscLastNameAsc();
    }

    @Override
    public Member getMemberById(Long id) {
        return memberRepository.findById(id).get();
    }

    @Override
    public Member addNewMember(Member member) {
        member.setJoiningDate( new Date() );
        return memberRepository.save( member );
    }

    @Override
    public Member saveMember(Member member) {
        return memberRepository.save( member );
    }

    @Override
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    @Override
    public void deleteMember(Member member) {
        memberRepository.delete(member);
    }

    @Override
    public Long getStudentsCount() {
        return memberRepository.countByType(Constants.MEMBER_STUDENT);
    }
}
