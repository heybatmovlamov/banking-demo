package az.edu.turing.mstransfer.service;

import az.edu.turing.mstransfer.client.AccountFeignClient;
import az.edu.turing.mstransfer.model.dto.AccountDto;
import az.edu.turing.mstransfer.model.dto.AccountUpdateBalance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AccountService {
    private final AccountFeignClient accountFeignClient;

    public Optional<AccountDto> findByCartNumber(String cartNumber) {
        return accountFeignClient.findByCartNumber(cartNumber);
    }

    public void updateBalance(String cartNumber, BigDecimal balance) {
        AccountUpdateBalance accountUpdateBalance = new AccountUpdateBalance();
        accountUpdateBalance.setCartNumber(cartNumber);
        accountUpdateBalance.setAmount(balance);
        accountFeignClient.updateAccountBalance(accountUpdateBalance);
    }

}
