package az.edu.turing.mstransfer.service;

import az.edu.turing.mstransfer.client.UserFeignClient;
import az.edu.turing.mstransfer.model.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserFeignClient userFeignClient;

    public UserDto getUser(String finCode){
        return userFeignClient.findUserByFinCode(finCode);
    }
}
