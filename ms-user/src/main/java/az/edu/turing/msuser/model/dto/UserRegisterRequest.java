package az.edu.turing.msuser.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequest {

        @NotEmpty(message = "Full name cannot be empty")
        private String fullName;

        @NotEmpty(message = "FinCode cannot be empty")
        private String fin;

        @NotEmpty(message = "Password cannot be empty")
        @Size(min = 6, message = "Password must be at least 6 characters long")
        private String password;

        @NotEmpty(message = "Email cannot be empty")
        @Email(message = "Email should be valid")
        private String email;
}
