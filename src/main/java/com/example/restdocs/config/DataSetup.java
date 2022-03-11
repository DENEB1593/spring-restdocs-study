package com.example.restdocs.config;

import com.example.restdocs.member.Member;
import com.example.restdocs.member.MemberReopository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSetup implements ApplicationRunner {

    private final MemberReopository memberReopository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        final List<Member> members = List.of(
                new Member("aaa@naver.com", "yun"),
                new Member("bbb@naver.com", "jin"),
                new Member("ccc@naver.com", "han"),
                new Member("ddd@naver.com", "job")
        );

        memberReopository.saveAll(members);
    }
}
