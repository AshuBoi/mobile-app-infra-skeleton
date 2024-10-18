package com.AshuBoi.app.ws.mobile_app_ws.Model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDetailsRequestModel {

    @NotNull(message = "first name cannot be empty")
    @Size(min=2,message = "First name cannot be less than 2 characters")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    @Size(min=2,message = "First name cannot be less than 2 characters")
    private String lastName;

    @NotNull(message = "Email cannot be null")
    @Email
    private String email;

    @NotNull(message = "Cannot be null")
    @Size(min=8, max = 16, message="Password must be equal or greater than 8 characters and less than 16 characters")
    private String password;

}
