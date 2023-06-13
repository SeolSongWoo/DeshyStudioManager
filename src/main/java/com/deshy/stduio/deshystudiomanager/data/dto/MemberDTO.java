package com.deshy.stduio.deshystudiomanager.data.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.NonNull;

@Getter
@Setter
@ToString
public class MemberDTO {
    @NotEmpty
    private String memberName;
    @NotEmpty
    private String memberId;
    @NotEmpty
    private String memberPassword;
    @NotEmpty
    private String memberEmail;
    @NotEmpty
    private String memberPhone;
}
