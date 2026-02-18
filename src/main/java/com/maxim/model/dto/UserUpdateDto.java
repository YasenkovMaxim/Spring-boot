package com.maxim.model.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

@Data
public class UserUpdateDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
}
