package com.example.restdocs.member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberReopository extends JpaRepository<Member, Long> {
}
