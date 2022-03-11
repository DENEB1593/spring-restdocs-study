package com.example.restdocs.member;

import lombok.Getter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
public class MemberSignUpRequest {

    @NotEmpty
    private String name;

    @Email
    private String email;

    public Member toEntity() {
        return new Member(this.name, this.email);
    }

}
