package com.deshy.stduio.deshystudiomanager.service;

import com.deshy.stduio.deshystudiomanager.data.dto.MemberDTO;
import com.deshy.stduio.deshystudiomanager.data.entity.Member;
import com.deshy.stduio.deshystudiomanager.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    public Optional<Member> findOne(String memberId) {
        return memberRepository.findMemberByMemberId(memberId);
    }

    public void signUp(MemberDTO memberDTO) {
        Member member = Member.createMember(memberDTO.getMemberName(), memberDTO.getMemberId(), memberDTO.getMemberPassword(), memberDTO.getMemberEmail(), memberDTO.getMemberPhone(), passwordEncoder);
        memberRepository.save(member);
    }
}
