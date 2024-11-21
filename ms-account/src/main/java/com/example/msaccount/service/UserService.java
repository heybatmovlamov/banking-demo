package com.example.msaccount.service;

import com.example.msaccount.client.UserFeignClient;
import com.example.msaccount.model.response.UserRegisterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserFeignClient feignClient;

     public Optional<UserRegisterResponse> getUser(String fin){
         return feignClient.getUserByFin(fin);
     }
}
