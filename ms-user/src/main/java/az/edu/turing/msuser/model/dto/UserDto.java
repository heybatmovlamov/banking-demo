package az.edu.turing.msuser.model.dto;

import jakarta.validation.constraints.NotBlank;

public class UserDto {

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
