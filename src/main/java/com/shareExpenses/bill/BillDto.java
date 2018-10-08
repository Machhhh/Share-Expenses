package com.shareExpenses.bill;

import com.shareExpenses.contribution.ContributionDto;
import com.shareExpenses.donation.DonationDto;
import com.shareExpenses.item.ItemDto;
import com.shareExpenses.participant.ParticipantDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BillDto {

    private String uuid;
    private String name;
    private Set<ItemDto> itemDtos;
    private Set<ParticipantDto> participantDtos;
    private Set<ContributionDto> contributionDtos;
    private Set<DonationDto> donationDtos;
}