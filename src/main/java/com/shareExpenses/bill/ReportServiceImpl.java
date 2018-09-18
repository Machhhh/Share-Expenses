package com.shareExpenses.bill;

import com.shareExpenses.contribution.Contribution;
import com.shareExpenses.item.Item;
import com.shareExpenses.item.ItemFacade;
import com.shareExpenses.participant.Participant;
import com.shareExpenses.participant.ParticipantFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Set;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {

    private ParticipantFacade participantFacade;
    private ItemFacade itemFacade;

    @Autowired
    public ReportServiceImpl(ParticipantFacade participantFacade, ItemFacade itemFacade) {
        this.participantFacade = participantFacade;
        this.itemFacade = itemFacade;
    }

    @Override
    public BigDecimal submitParticipant(String uuid) {
        Participant participant = participantFacade.getParticipantByUuid(uuid);
        Set<Contribution> contributionsOfParticipant = participant.getContributions();
        BigDecimal contributionInOneItem;
        BigDecimal totalContributionOfParticipant = new BigDecimal(0);
        for (Contribution contribution : contributionsOfParticipant) {
            contributionInOneItem = contribution.getItem().getPrice();
            Item item = itemFacade.getItemByUuid(contribution.getItem().getUuid());
            Set<Contribution> contributionsOfItem = item.getContributions();
            BigDecimal numberOfParticipants = new BigDecimal(contributionsOfItem.size());
            contributionInOneItem = contributionInOneItem.divide(numberOfParticipants);
            totalContributionOfParticipant = totalContributionOfParticipant.add(contributionInOneItem);
        }
        return totalContributionOfParticipant;
    }
}
