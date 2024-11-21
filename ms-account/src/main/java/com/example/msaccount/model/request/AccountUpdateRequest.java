package com.example.msaccount.model.request;

import lombok.Data;

@Data
public class AccountUpdateRequest {
    private String cartNumber;
    private String oldPin;
    private String newPin;
}
