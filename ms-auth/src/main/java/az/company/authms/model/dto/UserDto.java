package az.company.authms.model.dto;

import lombok.AllArgsConstructor;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {

    @NotBlank(message = "Name is required")
    @Size(max = 50, message = "Name cannot exceed 50 characters")
    private String fullName;

    @NotBlank(message = "Surname is required")
    @Size(max = 50, message = "Surname cannot exceed 50 characters")
    private String surname;

    @NotBlank(message = "FIN code is required")
    @Size(min = 7, max = 7, message = "FIN code must be exactly 7 characters")
    private String fin;

    @Min(value = 18, message = "Age must be at least 18")
    private int age;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Size(max = 100, message = "Email cannot exceed 100 characters")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^(\\+\\d{1,3}[- ]" +
            "?)?\\d{10}$", message = "Invalid phone number format")
    private String phoneNumber;

    @Size(max = 255, message = "Address cannot exceed 255 characters")
    private String address;

    @NotBlank
    private String password;

}