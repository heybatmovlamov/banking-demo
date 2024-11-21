package az.edu.turing.msuser.controller;

import az.edu.turing.msuser.model.dto.UserRegisterRequest;
import az.edu.turing.msuser.model.dto.UserRegisterResponse;
import az.edu.turing.msuser.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/save")
    public ResponseEntity<UserRegisterResponse> createUser(@RequestBody UserRegisterRequest userRegisterRequest) {
        UserRegisterResponse userRegisterResponse = userService.create(userRegisterRequest);
        return ResponseEntity.ok(userRegisterResponse);
    }
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.status(HttpStatus.OK).body("Test");
    }

    @GetMapping("/{fin}")
    public ResponseEntity<Optional<UserRegisterResponse>> getUserByFin(@PathVariable("fin") String fin) {
        return ResponseEntity.ok(userService.getByFin(fin));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserRegisterResponse> updateUser(@PathVariable Long id, @RequestBody UserRegisterRequest userRegisterRequest) {
        UserRegisterResponse updatedUser = userService.update(id, userRegisterRequest);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllUsers() {
        userService.deleteAll();
        return ResponseEntity.ok("All users deleted successfully.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok("User deleted successfully.");
    }
}
