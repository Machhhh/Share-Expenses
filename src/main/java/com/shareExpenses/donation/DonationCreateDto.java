package com.shareExpenses.donation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DonationCreateDto {

    private String participantUuid;
    private String billNumber;
    private BigDecimal Amount;
}