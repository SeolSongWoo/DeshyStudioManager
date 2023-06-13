package com.deshy.stduio.deshystudiomanager.data.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Table(name = "member")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    private Long memberSeq;

    private String memberName;
    private String memberId;
    private String memberPassword;
    private String memberEmail;
    private String memberPhone;
    private String memberRole;

    public static Member createMember(String memberName, String memberId, String memberPassword, String memberEmail, String memberPhone, PasswordEncoder passwordEncoder) {
        return new Member(null,memberName, memberId, passwordEncoder.encode(memberPassword), memberEmail, memberPhone, "USER");
    }
}
