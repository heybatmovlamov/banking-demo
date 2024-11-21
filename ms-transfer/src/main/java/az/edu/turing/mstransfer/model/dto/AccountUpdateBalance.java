package az.edu.turing.mstransfer.model.dto;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class AccountUpdateBalance {

    private String cartNumber;
    private BigDecimal amount;
}
