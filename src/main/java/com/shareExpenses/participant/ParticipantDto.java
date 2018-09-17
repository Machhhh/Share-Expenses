package com.shareExpenses.participant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantDto {

    private String uuid;
    private String name;
    private String billNumber;
    private Set<ContributionDto> contributionDtos;
}
