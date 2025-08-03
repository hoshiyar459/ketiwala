package com.varun.khetiwala.data;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private String username;
    private String email;
    private String mobileNumber;
    private String password;
    private String profilePic;
    private Integer role;
    private String locale;

}

