package com.example.msaccount.service;

import com.example.msaccount.client.TransferFeignClient;
import com.example.msaccount.model.request.AccountTransferRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TransferService {
    private final TransferFeignClient transferFeignClient;

    public String transfer(String auth,AccountTransferRequest transferRequest) {
       return transferFeignClient.transferMoney(auth,transferRequest);
    }
}
