package com.deshy.stduio.deshystudiomanager.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("basePackages = com.deshy.stduio.deshystudiomanager.controller.mvc")
public class MvcGlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        return "redirect:/error";
    }
}
