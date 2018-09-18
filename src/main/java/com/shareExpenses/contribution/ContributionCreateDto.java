package com.shareExpenses.contribution;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContributionCreateDto {

    private String participantUuid;
    private String itemUuid;
    private String billNumber;
}
