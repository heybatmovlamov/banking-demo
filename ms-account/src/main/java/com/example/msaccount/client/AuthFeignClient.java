package com.example.msaccount.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-auth",url = "http://localhost:8082")
public interface AuthFeignClient {

    @GetMapping("/{fin}")
    String auth(@PathVariable("fin") String fin);
}
