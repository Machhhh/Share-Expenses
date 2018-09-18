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
public class DonationDto {

    private String uuid;
    private BigDecimal Amount;
    private String participantName;
    private String participantUuid;
    private String billNumber;
}


