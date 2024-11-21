package az.edu.turing.mstransfer.service;

import az.edu.turing.mstransfer.model.TransferRequest;
import az.edu.turing.mstransfer.model.dto.AccountDto;
import az.edu.turing.mstransfer.model.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransferService {
   private final UserService userService;
   private final AccountService accountService;

    public TransferRequest transfer(String finCode, TransferRequest transferRequest) {
        UserDto user = userService.getUser(finCode);
        List<AccountDto> accounts = user.getAccounts();

        accounts.stream()
                .filter(a -> a.getCartNumber().equals(transferRequest.getMyCartNumber()))
                .findFirst().orElseThrow(() -> new RuntimeException("Invalid cart number"));

        AccountDto myAccount = accountService
                .findByCartNumber(transferRequest.getMyCartNumber())
                .orElseThrow(() -> new RuntimeException("Cart number not found"));

        AccountDto transferAccount = accountService
                .findByCartNumber(transferRequest.getTransferCartNumber())
                .orElseThrow(() -> new RuntimeException("Cart number not found"));

        if (myAccount.getBalance().compareTo(transferRequest.getAmount()) >= 0) {
            myAccount.setBalance(myAccount.getBalance().subtract(transferRequest.getAmount()));
            transferAccount.setBalance(transferAccount.getBalance().add(transferRequest.getAmount()));

            accountService.updateBalance(myAccount.getCartNumber(),myAccount.getBalance());
            accountService.updateBalance(transferAccount.getCartNumber(),transferAccount.getBalance());

            log.info("Transfer tamamlandı");
        } else {
            log.info("Balans kifayət etmir");
        }
        return transferRequest;
    }
}
