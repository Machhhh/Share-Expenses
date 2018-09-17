package com.shareExpenses.contribution;


import com.shareExpenses.participant.ParticipantDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;


@Service
@Transactional
public class ContributionServiceImpl implements ContributionService{

    private ContributionMapper contributionMapper;
    private ContributionRepository contributionRepository;

    public ContributionServiceImpl(ContributionMapper contributionMapper, ContributionRepository contributionRepository) {
        this.contributionMapper = contributionMapper;
        this.contributionRepository = contributionRepository;
    }

    @Override
    public void deleteByUuid(String uuid) {

    }

    @Override
    public ParticipantDto findOneByUuid(String uuid) {
        return null;
    }

    @Override
    public Set<ContributionDto> findAll() {
        return null;
    }

    @Override
    public ContributionCreateDto create(ContributionCreateDto contributionCreateDto) {
        return null;
    }
}
