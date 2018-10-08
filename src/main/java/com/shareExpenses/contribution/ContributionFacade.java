package com.shareExpenses.contribution;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@AllArgsConstructor
@Getter
public class ContributionFacade {

    ContributionService contributionService;

    public ContributionDto getContributionDtoByUuid(String uuid) {
        return contributionService.findOneByUuid(uuid);
    }

    public Set<ContributionDto> getContributionDtoSet() {
        return contributionService.findAll();
    }
}