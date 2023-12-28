package com.springmvc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonException {

    @ExceptionHandler(RuntimeException.class)
    private ModelAndView handleErrorCommon(Exception exception) {

    }
}
