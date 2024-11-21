package com.example.msaccount.service;

import com.example.msaccount.model.dto.AccountDto;
import com.example.msaccount.model.response.AccountResponse;
import com.example.msaccount.dao.entity.AccountEntity;
import com.example.msaccount.dao.repository.AccountRepository;
import com.example.msaccount.enums.AccountStatus;
import com.example.msaccount.exception.AccountsNotFoundException;
import com.example.msaccount.exception.CartNotFoundException;
import com.example.msaccount.exception.InvalidCartNumberException;
import com.example.msaccount.mapper.AccountMapper;
import com.example.msaccount.model.response.UserRegisterResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountService {
    private final CartGenerationService cartGenerationService;
    private final AccountRepository accountRepository;
    private final UserService userService;
    private final AccountMapper accountMapper;


    @Transactional
    public AccountDto createAccount(String finCode) {
        Optional<UserRegisterResponse> user = userService.getUser(finCode);
        AccountDto cart = cartGenerationService.createCart();
        AccountEntity accountEntity = accountMapper.dtoToEntity(cart);
        accountEntity.setUserId(user.get().getId());
        AccountEntity savedEntity = accountRepository.save(accountEntity);

        return accountMapper.entityToDto(savedEntity);
    }

    @Transactional
    public void blockAccount(String cartNumber) {
        AccountEntity byCartNumber = accountRepository.findByCartNumber(cartNumber).orElseThrow(() -> new CartNotFoundException("Cart not found"));
        byCartNumber.setAccountStatus(AccountStatus.BLOCKED);
        accountRepository.save(byCartNumber);
    }

    @Transactional(readOnly = true)
    public List<AccountResponse> getMyAccount(String finCode) {
        UserRegisterResponse userDto = userService.getUser(finCode)
                .orElseThrow(() -> new RuntimeException("User not found with finCode: " + finCode));

        List<AccountEntity> accountsByUserId = accountRepository.findAccountsByUserId(userDto.getId());

        if (accountsByUserId.isEmpty()) {
            throw new AccountsNotFoundException("No accounts found for user with finCode: " + finCode);
        }

        return accountMapper.entityListToAccountResponseList(accountsByUserId);
    }

    @Transactional
    public void updatePin(String finCode, String cartNumber, String oldPin, String newPin) {
        UserRegisterResponse userEntity = userService.getUser(finCode)
                .orElseThrow(() -> new RuntimeException("User not found with finCode: " + finCode));

        List<AccountEntity> accountsByUserId = accountRepository.findAccountsByUserId(userEntity.getId());
        AccountEntity matchesAccount = accountsByUserId.stream().filter(account -> account.getCartNumber().equals(cartNumber)).findFirst().orElseThrow(() -> new CartNotFoundException("Cart not found"));

        boolean equals = matchesAccount.getPin().equals(oldPin);
        if (equals) {
            matchesAccount.setPin(newPin);
            accountRepository.updateAccountEntityByCartNumber(cartNumber, matchesAccount);
        } else {
            throw new InvalidCartNumberException("Pin code false ");
        }
    }
}