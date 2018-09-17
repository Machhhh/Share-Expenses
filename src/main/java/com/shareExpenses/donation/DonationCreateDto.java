package com.shareExpenses.donation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DonationCreateDto {

    private String name;
    private BigDecimal Ammount;
}