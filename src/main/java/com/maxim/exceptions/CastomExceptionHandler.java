package com.maxim.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CastomExceptionHandler {

    @ExceptionHandler(value ={Exception.class})
    public ModelAndView exceptionHandler(Exception e){ // более глобальный на случай выпадения ошибок которые не обрабтаны другими методами
        System.out.println("ExceptionHadler: " + e);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errors", e.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }

    @ExceptionHandler(value ={SecurityNotFound.class})
    public ModelAndView SecurityNotFoundExceptionHandler(SecurityNotFound e){
        System.out.println("ExceptionHadler: " + e);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errors", e.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
