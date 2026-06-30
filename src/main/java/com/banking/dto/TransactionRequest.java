package com.banking.dto;

import lombok.Data;

@Data
public class TransactionRequest {

    private String accountNumber;
    private Double amount;

}