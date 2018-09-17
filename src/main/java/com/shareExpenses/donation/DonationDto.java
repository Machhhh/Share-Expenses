package com.shareExpenses.donation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DonationDto {

    private String uuid;
    private String name;
    private BigDecimal Ammount;
    private Set<DonationDto> donationDtos;
}


