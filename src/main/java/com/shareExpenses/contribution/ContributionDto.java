package com.shareExpenses.contribution;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContributionDto {

    private String uuid;
    private String billNumber;
    private String itemUuid;
    private String itemName;
    private String participantUuid;
    private String participantName;
}
