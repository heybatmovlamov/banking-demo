package az.company.authms.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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