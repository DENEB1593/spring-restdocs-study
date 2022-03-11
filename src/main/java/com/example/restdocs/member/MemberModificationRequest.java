package com.example.restdocs.member;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class MemberModificationRequest {

    @NotEmpty
    private String name;

}
