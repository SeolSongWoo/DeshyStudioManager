package com.deshy.stduio.deshystudiomanager.authentication;

import com.deshy.stduio.deshystudiomanager.data.entity.Member;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@AuthenticationPrincipal(expression = "member")
public @interface AuthUser {
}
