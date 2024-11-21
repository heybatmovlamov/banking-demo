package az.company.authms.client;

import az.company.authms.model.dto.UserRegisterRequest;
import az.company.authms.model.dto.UserRegisterResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Service
@FeignClient(name="ms-user",url="http://localhost:8081")
public interface UserFeignClient {

    @GetMapping("/{fin}")
    Optional<UserRegisterResponse> getUserByFin(@PathVariable("fin") String fin);
    @PostMapping("/save")
    UserRegisterResponse saveUser(@RequestBody UserRegisterRequest userRegisterRequest);


}
