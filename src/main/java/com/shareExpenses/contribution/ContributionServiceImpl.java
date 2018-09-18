package com.shareExpenses.contribution;


import com.shareExpenses.bill.Bill;
import com.shareExpenses.item.Item;
import com.shareExpenses.participant.Participant;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;


@Service
@Transactional
class ContributionServiceImpl implements ContributionService {

    private ContributionMapper contributionMapper;
    private ContributionRepository contributionRepository;
    private ContributionFacade contributionFacade;

    public ContributionServiceImpl(ContributionMapper contributionMapper, ContributionRepository contributionRepository, ContributionFacade contributionFacade) {
        this.contributionMapper = contributionMapper;
        this.contributionRepository = contributionRepository;
        this.contributionFacade = contributionFacade;
    }

    @Override
    public void deleteByUuid(String uuid) {
        contributionRepository.deleteByUuid(uuid);
    }

    @Override
    public ContributionDto findOneByUuid(String uuid) {
        return contributionMapper.toContributionDto(contributionRepository.findByUuid(uuid));
    }

    @Override
    public Set<ContributionDto> findAll() {
        return contributionMapper.toContributionDtoSet(contributionRepository.findAllBy());
    }

    @Override
    public ContributionCreateDto create(ContributionCreateDto dto) {
        Bill bill = contributionFacade.getBillFacade().getBillByUuid(dto.getBillNumber());
        Participant participant = contributionFacade.getParticipantFacade()
                .getParticipantByUuid(dto.getParticipantUuid());
        Item item = contributionFacade.getItemFacade().getItemByUuid(dto.getItemUuid());
        Contribution contribution = Contribution.create()
                .bill(bill)
                .participant(participant)
                .item(item)
                .build();
        return contributionMapper.toContributionCreateDto(contributionRepository.save(contribution));
    }
}