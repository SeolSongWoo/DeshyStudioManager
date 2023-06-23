package com.deshy.stduio.deshystudiomanager.controller.rest.user;

import com.deshy.stduio.deshystudiomanager.controller.rest.response.CommonCode;
import com.deshy.stduio.deshystudiomanager.controller.rest.response.CommonResponse;
import com.deshy.stduio.deshystudiomanager.data.dto.MemberDTO;
import com.deshy.stduio.deshystudiomanager.service.MemberServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final MemberServiceImpl memberService;

    @PostMapping("/signup")
    public ResponseEntity<CommonResponse<?>> signUp(@Valid @RequestBody MemberDTO memberDTO) {
        memberService.signUp(memberDTO);
        return new ResponseEntity<>(CommonResponse.success(null,CommonCode.CREATE_OK), HttpStatus.CREATED);
    }
}
