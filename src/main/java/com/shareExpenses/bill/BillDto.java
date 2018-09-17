package com.shareExpenses.bill;

import com.shareExpenses.participant.ParticipantDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BillDto {

    String name;
    private Set<ItemDto> itemDtos;
    private Set<ParticipantDto> participantDtos;
    private Set<ContributionDto> contributionDtos;
    private Set<DonationDto> donationDtos;
}