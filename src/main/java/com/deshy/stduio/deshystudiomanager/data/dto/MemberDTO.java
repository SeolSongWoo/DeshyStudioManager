package com.deshy.stduio.deshystudiomanager.data.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {
    @NotEmpty
    private String name;
    @NotEmpty
    private String id;
    @NotEmpty
    private String password;
    @NotEmpty
    private String email;
    @NotEmpty
    private String phone;
}
