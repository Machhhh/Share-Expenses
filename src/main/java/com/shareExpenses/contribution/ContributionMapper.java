package com.shareExpenses.contribution;

import java.util.Set;

interface ContributionMapper {
    public ContributionDto toContributionDto(Contribution byUuid);

    public Set<ContributionDto> toContributionDtoSet(Set<Contribution> allBy);
}
