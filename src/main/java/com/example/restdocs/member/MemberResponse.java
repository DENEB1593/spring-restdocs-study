package com.example.restdocs.member;

import lombok.Getter;

@Getter
public class MemberResponse {
    private final String name;
    private final String email;

    public MemberResponse(final Member member) {
        this.name = member.getName();
        this.email = member.getEmail();
    }

}
