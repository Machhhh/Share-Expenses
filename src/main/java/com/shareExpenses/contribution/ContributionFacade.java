package com.shareExpenses.contribution;

import com.shareExpenses.bill.BillFacade;
import com.shareExpenses.item.ItemFacade;
import com.shareExpenses.participant.ParticipantFacade;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@AllArgsConstructor
@Getter
public class ContributionFacade {

    private ContributionRepository contributionRepository;
    private ContributionMapper contributionMapper;
    private BillFacade billFacade;
    private ParticipantFacade participantFacade;
    private ItemFacade itemFacade;

    public ContributionDto getContributionDtoByUuid(String uuid) {
        return contributionMapper.toContributionDto(contributionRepository.findByUuid(uuid));
    }

    public Set<ContributionDto> getContributionDtoSet() {
        return contributionMapper.toContributionDtoSet(contributionRepository.findAllBy());
    }
}