package com.banks.doggo.repository;

import com.banks.doggo.model.Member;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest

public class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void findUserForBilling() {
        memberRepository.saveAll(Lists.newArrayList(
                new Member("Banks", "Abawonse", "password", "banks@gmail.com")));
        Member member = memberRepository.findByEmail("banks@gmail.com");
    }
}
