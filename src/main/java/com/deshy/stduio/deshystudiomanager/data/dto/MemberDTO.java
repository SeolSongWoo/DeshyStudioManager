package com.deshy.stduio.deshystudiomanager.data.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {
    private String memberName;
    private String memberId;
    private String memberPassword;
    private String memberEmail;
    private String memberPhone;
}
