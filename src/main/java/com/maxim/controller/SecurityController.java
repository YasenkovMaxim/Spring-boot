package com.maxim.controller;

import com.maxim.exceptions.SecurityNotFound;
import com.maxim.model.dto.RequestRegistrationDTO;
import com.maxim.model.dto.UserResponse;
import com.maxim.service.SecurityService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/security")

public class SecurityController {
    private final SecurityService securityService;

    public SecurityController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @GetMapping("/registration")
    public String getRegistrationPage() {
        return "registration";
    }

    @PostMapping("/registration")
    public ModelAndView registration(@ModelAttribute @Valid RequestRegistrationDTO registrationDTO,
                                     BindingResult bindingResult,
                                     ModelAndView modelAndView) {

        // обработка ошибок при валидации
        if (bindingResult.hasErrors()) {
            for (ObjectError objectError : bindingResult.getAllErrors()) {
                System.out.println(objectError.getDefaultMessage());
            }
            modelAndView.addObject("errors", bindingResult.getAllErrors()); // помещает отчет об ошибках на стр.
            modelAndView.setViewName("error");// на какую стр перекинет
            return modelAndView;
        }

        UserResponse userResponse = securityService.registration(registrationDTO);
        modelAndView.addObject("first_name", userResponse.getFirstName());
        modelAndView.addObject("last_name", userResponse.getLastName());
        modelAndView.addObject("age", userResponse.getAge());
        modelAndView.addObject("email", userResponse.getEmail());
        modelAndView.setViewName("registration-response");
        return modelAndView;
    }


    //@ExceptionHandler(value ={SecurityNotFound.class, Exception.class})
    //public ModelAndView exceptionHandler(Exception e){
    //    ModelAndView modelAndView = new ModelAndView();
    //    System.out.println("exceptionHadler method in SecurityConrtoller. Exception: " + e);
    //    modelAndView.addObject("errors", e.getMessage());
    //    modelAndView.setViewName("error");
    //    return modelAndView;
    //}
}
