package com.example.msaccount.client;

import com.example.msaccount.model.response.UserRegisterResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name="ms-user",url="http://localhost:8081")
public interface UserFeignClient {

    @GetMapping("/{fin}")
    Optional<UserRegisterResponse> getUserByFin(@PathVariable("fin") String fin);

}
