package com.shareExpenses.contribution;

import com.shareExpenses.bill.Bill;
import com.shareExpenses.bill.BillFacade;
import com.shareExpenses.item.Item;
import com.shareExpenses.item.ItemFacade;
import com.shareExpenses.participant.Participant;
import com.shareExpenses.participant.ParticipantFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
@Transactional
class ContributionServiceImpl implements ContributionService {

    private ContributionMapper contributionMapper;
    private ContributionRepository contributionRepository;
    private BillFacade billFacade;
    private ItemFacade itemFacade;
    private ParticipantFacade participantFacade;

    @Autowired
    public ContributionServiceImpl(ContributionMapper contributionMapper,
                                   ContributionRepository contributionRepository,
                                   BillFacade billFacade,
                                   ItemFacade itemFacade,
                                   ParticipantFacade participantFacade) {
        this.contributionMapper = contributionMapper;
        this.contributionRepository = contributionRepository;
        this.billFacade = billFacade;
        this.itemFacade = itemFacade;
        this.participantFacade = participantFacade;
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
        Bill bill = billFacade.getBillByUuid(dto.getBillNumber());
        Participant participant = participantFacade.getParticipantByUuid(dto.getParticipantUuid());
        Item item = itemFacade.getItemByUuid(dto.getItemUuid());
        Contribution contribution = Contribution.create()
                .bill(bill)
                .participant(participant)
                .item(item)
                .build();
        return contributionMapper.toContributionCreateDto(contributionRepository.save(contribution));
    }
}