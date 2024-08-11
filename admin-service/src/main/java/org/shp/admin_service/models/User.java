package org.shp.admin_service.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;
    private String firstname;
    private String lastname;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthdate;
    private String phoneNumber;
    private String bio;
    private String image;
    private boolean enabled;

}

