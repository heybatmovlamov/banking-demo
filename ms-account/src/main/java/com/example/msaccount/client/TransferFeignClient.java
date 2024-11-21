package com.example.msaccount.client;

import com.example.msaccount.model.request.AccountTransferRequest;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "ms-transfer",url = "http://localhost:8083")
public interface TransferFeignClient {

    @PostMapping("/transfer")
    AccountTransferRequest transferMoney( @RequestHeader("Authorization") String auth,
                          @Valid @RequestBody AccountTransferRequest requestDto);
}
