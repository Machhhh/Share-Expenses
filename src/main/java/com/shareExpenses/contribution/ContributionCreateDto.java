package com.shareExpenses.contribution;

import com.shareExpenses.item.Item;
import com.shareExpenses.participant.Participant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContributionCreateDto {

    private Item item;
    private Participant participant;
}
