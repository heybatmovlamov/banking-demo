package az.edu.turing.mstransfer.client;

import az.edu.turing.mstransfer.model.dto.AccountDto;
import az.edu.turing.mstransfer.model.dto.AccountUpdateBalance;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@FeignClient(name = "ms-account", url ="http://ms-account")
public interface AccountFeignClient {

    @GetMapping("/{cartNumber}")
     Optional<AccountDto> findByCartNumber(@PathVariable String cartNumber);

    @PatchMapping("/update/balance")
    String  updateAccountBalance(@RequestBody AccountUpdateBalance accountUpdateBalance);


}
