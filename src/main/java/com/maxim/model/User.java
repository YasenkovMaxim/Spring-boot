package com.maxim.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

import java.time.Instant;

@Entity(name = "users")
@Data
public class User {
    @Id
    @SequenceGenerator(name = "seqUserId", sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "seqUserId")
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private Instant created;
    private Instant updated;
}
