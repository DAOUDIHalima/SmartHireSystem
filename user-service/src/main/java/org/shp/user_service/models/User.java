package org.shp.user_service.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String firstname;
    private String lastname;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthdate;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate createdAt;
    private String phoneNumber;
    private String bio;
    private String image;
    private boolean enabled;
}
