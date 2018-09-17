package com.shareExpenses.contribution;

import com.shareExpenses.participant.ParticipantDto;

import java.util.Set;

public interface ContributionService {

    void deleteByUuid(String uuid);

    ParticipantDto findOneByUuid(String uuid);

    Set<ContributionDto> findAll();

    ContributionCreateDto create(ContributionCreateDto contributionCreateDto);
}
