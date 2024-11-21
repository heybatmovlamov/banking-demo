package az.edu.turing.msuser.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Builder
//public record UserRegisterResponse(
//        Long id,
//        String fullName,
//        String fin,
//        String password,
//        String email
//) {
//}
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
