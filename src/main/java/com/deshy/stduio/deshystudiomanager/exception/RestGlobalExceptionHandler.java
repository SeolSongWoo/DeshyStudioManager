package com.deshy.stduio.deshystudiomanager.exception;

import com.deshy.stduio.deshystudiomanager.controller.rest.response.CommonCode;
import com.deshy.stduio.deshystudiomanager.controller.rest.response.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice(basePackages = "com.deshy.stduio.deshystudiomanager.controller.rest")
@Slf4j
public class RestGlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CommonResponse<?>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.info("handleMethodArgumentNotValidException", e);
        return new ResponseEntity<>(CommonResponse.fail(CommonCode.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingPathVariableException.class)
    public ResponseEntity<CommonResponse<?>> handleMissingPathVariableException(MissingPathVariableException e) {
        log.info("handleMissingPathVariableException", e);
        return new ResponseEntity<>(CommonResponse.fail(CommonCode.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TypeMismatchException.class)
    public ResponseEntity<CommonResponse<?>> handleTypeMismatchException(TypeMismatchException e) {
        log.info("handleTypeMismatchException", e);
        return new ResponseEntity<>(CommonResponse.fail(CommonCode.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<CommonResponse<?>> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        log.info("handleMethodArgumentTypeMismatchException", e);
        return new ResponseEntity<>(CommonResponse.fail(CommonCode.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<CommonResponse<?>> handleUserNameNotFoundExceptionHandler(UsernameNotFoundException e) {
        log.info("handleUserNameNotFoundExceptionHandler",e);
        return new ResponseEntity<>(CommonResponse.fail(CommonCode.USER_NOT_FOUND),HttpStatus.NOT_FOUND);
    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<CommonResponse<?>> handleException(Exception e) {
        log.error("handleException", e);
        return new ResponseEntity<>(CommonResponse.error(CommonCode.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
