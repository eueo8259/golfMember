package com.example.golfMember.service;

import com.example.golfMember.dto.MemberDto;
import com.example.golfMember.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<MemberDto> membersAll() {
        List<MemberDto> memberDtoList = new ArrayList<>();
        return memberRepository.findAll().stream()
                .map(x -> MemberDto.fromMemberEntity(x)).toList();
    }

    public MemberDto findMemberById(String memberId) {
        return memberRepository.findById(memberId)
                .map(x->MemberDto.fromMemberEntity(x))
                .orElse(null);
    }
}
