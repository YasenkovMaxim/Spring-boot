package com.maxim.service;

import com.maxim.model.dto.RequestRegistrationDTO;
import com.maxim.model.dto.UserResponse;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {
    public UserResponse registration(RequestRegistrationDTO registrationDTO){
        System.out.println(registrationDTO.getUsername());
        System.out.println(registrationDTO.getPassword());
        System.out.println(registrationDTO.getFirstName());
        System.out.println(registrationDTO.getLastName());
        System.out.println(registrationDTO.getEmail());
        System.out.println(registrationDTO.getAge());
        System.out.println("Registration successfully"); //TODO: сделать регистрацию.

        UserResponse userResponse = new UserResponse();

        userResponse.setFirstName(registrationDTO.getFirstName());
        userResponse.setLastName(registrationDTO.getLastName());
        userResponse.setAge(registrationDTO.getAge());
        userResponse.setEmail(registrationDTO.getEmail());
        return userResponse;
    }
}
