package com.maxim.model;

import lombok.Data;

import java.time.Instant;

@Data
public class Security {
    private Integer id;
    private String username;
    private String password;
    private Role role;
    private String userId;
    private Instant created;
    private Instant updated;
}
