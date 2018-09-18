package com.shareExpenses.item;

import com.shareExpenses.contribution.ContributionDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    private String uuid;
    private String name;
    private BigDecimal price;
    private String billNumber;
    private Set<ContributionDto> contributionDtos;
}
