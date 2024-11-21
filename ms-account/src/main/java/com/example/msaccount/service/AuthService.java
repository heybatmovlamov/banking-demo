package com.example.msaccount.service;

import com.example.msaccount.client.AuthFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private  final AuthFeignClient authFeignClient;

    public String getFin(String authReq){
        return authFeignClient.auth(authReq);
    }
}
