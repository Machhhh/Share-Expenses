package com.shareExpenses.contribution;

import java.util.Set;

interface ContributionService {

    void deleteByUuid(String uuid);

    ContributionDto findOneByUuid(String uuid);

    Set<ContributionDto> findAll();

    ContributionCreateDto create(ContributionCreateDto contributionCreateDto);
}
