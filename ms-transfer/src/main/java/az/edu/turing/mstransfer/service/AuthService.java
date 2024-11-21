package az.edu.turing.mstransfer.service;

import az.edu.turing.mstransfer.client.AuthFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final AuthFeignClient authFeignClient;

    public String getFinCodeFromAuth(String authToken) {
        return authFeignClient.getFinCode(authToken);
    }



}
