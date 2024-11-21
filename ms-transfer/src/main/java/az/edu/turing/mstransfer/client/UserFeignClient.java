package az.edu.turing.mstransfer.client;

import az.edu.turing.mstransfer.model.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(name = "ms-user",url = "http://ms-auth")
public interface UserFeignClient {

    @GetMapping("/{finCode}")
    UserDto findUserByFinCode(@PathVariable("finCode") String finCode);

}
