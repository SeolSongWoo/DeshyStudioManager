package com.deshy.stduio.deshystudiomanager.service;

import com.deshy.stduio.deshystudiomanager.authentication.CustomMember;
import com.deshy.stduio.deshystudiomanager.authentication.CustomMemberAdapter;
import com.deshy.stduio.deshystudiomanager.data.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    private final MemberServiceImpl memberService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> memberVO = memberService.findOne(username);
        Member member = memberVO.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));
        return new CustomMemberAdapter(member);
    }
}
