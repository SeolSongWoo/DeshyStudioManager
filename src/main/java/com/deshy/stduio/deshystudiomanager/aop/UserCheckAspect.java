package com.deshy.stduio.deshystudiomanager.aop;

import com.deshy.stduio.deshystudiomanager.data.entity.Member;
import com.deshy.stduio.deshystudiomanager.repository.MemberRepository;
import com.deshy.stduio.deshystudiomanager.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.security.Principal;

@Component
@Aspect
@RequiredArgsConstructor
public class UserCheckAspect {
    private final MemberServiceImpl memberService;


    @Around("execution(* *(.., @UserCheck (*), ..))")
    public Object validateUser(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();

        Parameter[] parameters = method.getParameters();

        for (Parameter parameter : parameters) {
            RequestParam requestParam = parameter.getAnnotation(RequestParam.class);
            if (requestParam != null) {
                throw new IllegalArgumentException("Invalid usage: @RequestParam is not allowed for member");
            }
            if (parameter.getAnnotation(UserCheck.class) != null) {
                Object[] args = pjp.getArgs();
                for (Object arg : args) {
                    if (arg instanceof Member) {
                        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                        String userName = user.getUsername();
                        Member existingMember = memberService.memberCheck(userName);
                        return pjp.proceed(new Object[]{existingMember});
                    }
                }
            }
        }
        return pjp.proceed();
    }
}
