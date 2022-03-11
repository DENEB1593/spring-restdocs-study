package com.example.restdocs.member;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberApi {

    private final MemberReopository memberReopository;

    @GetMapping("/{id}")
    public MemberResponse getMember(@PathVariable Long id) {
        final Member member = memberReopository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Member Not Found"));

        return new MemberResponse(member);
    }

    @PostMapping
    public void createMember(@RequestBody @Valid MemberSignUpRequest request) {
        memberReopository.save(request.toEntity());
    }

    @PutMapping("/{id}")
    public void modify(
            @PathVariable Long id,
            @RequestBody @Valid MemberModificationRequest request) {

        final Member member = memberReopository.findById(id).get();
        member.modify(member.getName());

    }

    @GetMapping
    public Page<MemberResponse> getMembers(
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable
            ) {
        return memberReopository.findAll(pageable).map(MemberResponse::new);
    }

}
