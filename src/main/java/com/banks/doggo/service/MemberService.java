package com.banks.doggo.service;

import com.banks.doggo.dto.MemberDto;
import com.banks.doggo.model.Member;
import com.banks.doggo.repository.MemberRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/** implements logic for Member class
 * @author Bankole Abawonse
 */
@Service
@NoArgsConstructor
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    /** Custom query for finding member by email.
     * @param email email to be queried against database.
     * @return Member with the email passed in.
     */
    public Member findMemberByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    public void addMember(MemberDto memberDto) {
        Member member = new Member();
        member.setFirstName(memberDto.getFirstName());
        member.setLastName(memberDto.getLastName());
        member.setEmail(memberDto.getEmail());
        member.setPassword(passwordEncoder.encode(memberDto.getPassword()));
        memberRepository.save(member);
    }

}
