package com.deshy.stduio.deshystudiomanager.authentication;

import com.deshy.stduio.deshystudiomanager.data.entity.Member;
import lombok.Getter;

@Getter
public class CustomMemberAdapter extends CustomMember{
    private Member member;

    public CustomMemberAdapter(Member member) {
        super(member);
        this.member = member;
    }
}
