package com.example.msaccount.model.response;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserRegisterResponse {
    @NotBlank
    private Long id;

    @NotBlank
    private String fullName;

    @NotBlank
    private String fin;

    @NotBlank
    private String password;

    @NotBlank
    private String email;
}
