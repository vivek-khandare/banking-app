package com.banking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Account Holder Name is required")
    @Column(nullable = false)
    private String accountHolderName;

    @NotBlank(message = "Account Number is required")
    @Column(nullable = false, unique = true)
    private String accountNumber;

    @PositiveOrZero(message = "Balance cannot be negative")
    @Column(nullable = false)
    private Double balance;
}