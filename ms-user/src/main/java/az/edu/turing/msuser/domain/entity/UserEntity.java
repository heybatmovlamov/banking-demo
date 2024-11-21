package az.edu.turing.msuser.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 7)
    private String fin;

    @Column(name = "full_name", length = 100)
    private String fullName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 50)
    private String email;
}
