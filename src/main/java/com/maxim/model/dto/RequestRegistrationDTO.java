package com.maxim.model.dto;

import com.maxim.annotations.IsAdult;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.context.annotation.Scope;

@Scope("prototype")
@Data
public class RequestRegistrationDTO {
    @NotNull
    @Size(min = 2, max = 20)
    @NotBlank
    private String username;

    @Pattern(regexp = "[A-z0-9]{6,}")
    private String password;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Email
    private String email;

    @IsAdult
    private Integer age;

}
