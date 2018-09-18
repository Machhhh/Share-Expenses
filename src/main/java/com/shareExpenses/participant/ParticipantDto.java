package com.shareExpenses.participant;

import com.shareExpenses.contribution.ContributionDto;
import com.shareExpenses.donation.DonationDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantDto {

    private String uuid;
    private String name;
    private String billNumber;
    private Set<ContributionDto> contributionDtos;
    private Set<DonationDto> donationDtos;
}