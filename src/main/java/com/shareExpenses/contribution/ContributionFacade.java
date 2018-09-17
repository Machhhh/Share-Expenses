package com.shareExpenses.contribution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
public class ContributionFacade {


    private ContributionRepository contributionRepository;
    private ContributionMapper contributionMapper;

    @Autowired

    public ContributionFacade(ContributionRepository contributionRepository, ContributionMapper contributionMapper) {
        this.contributionRepository = contributionRepository;
        this.contributionMapper = contributionMapper;
    }
    public ContributionDto getContributionDtoByUuid(String uuid) {
        return contributionMapper.toContributionDto(contributionRepository.findByUuid(uuid));
    }

    public ContributionDto getContributionDtoByName(String name) {
        return contributionMapper.toContributionDto(contributionRepository.findByName(name));
    }

    public Set<ContributionDto> getContributionDtoSet() {
        return contributionMapper.toContributionDtoSet(contributionRepository.findAllBy());
    }

}
