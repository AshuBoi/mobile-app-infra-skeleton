package com.AshuBoi.app.ws.mobile_app_ws.Model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UpdateUserDetailsRequestModel {
    @NotNull(message = "first name cannot be empty")
    @Size(min=2,message = "First name cannot be less than 2 characters")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    @Size(min=2,message = "First name cannot be less than 2 characters")
    private String lastName;
}
