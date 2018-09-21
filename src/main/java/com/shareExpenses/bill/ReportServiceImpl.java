package com.shareExpenses.bill;

import com.shareExpenses.contribution.Contribution;
import com.shareExpenses.donation.Donation;
import com.shareExpenses.item.Item;
import com.shareExpenses.item.ItemFacade;
import com.shareExpenses.participant.Participant;
import com.shareExpenses.participant.ParticipantDto;
import com.shareExpenses.participant.ParticipantFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

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
    public BigDecimal submitParticipantContribution(String uuid) {
        Participant participant = participantFacade.getParticipantByUuid(uuid);
        Set<Contribution> contributionsOfParticipant = participant.getContributions();
        BigDecimal contributionInOneItem;
        BigDecimal totalContributionOfParticipant = new BigDecimal(0);
        for (Contribution contribution : contributionsOfParticipant) {
            Item item = contribution.getItem();
            contributionInOneItem = item.getPrice();
            Set<Contribution> contributionsOfItem = item.getContributions();
            BigDecimal numberOfParticipants = new BigDecimal(contributionsOfItem.size());
            contributionInOneItem = contributionInOneItem.divide(numberOfParticipants);
            totalContributionOfParticipant = totalContributionOfParticipant.add(contributionInOneItem);
        }
        return totalContributionOfParticipant;
    }

    @Override
    public BigDecimal submitParticipantBilans(String uuid) {
        Participant participant = participantFacade.getParticipantByUuid(uuid);
        Set<Donation> donations = participant.getDonations();
        BigDecimal totalDonation = new BigDecimal(0);
        for (Donation donation : donations) {
            totalDonation = totalDonation.add(donation.getAmount());
        }
        return submitParticipantContribution(uuid).subtract(totalDonation);
    }

    @Override
    public ReportDto report(String billUuid) {
        final ReportDto result = new ReportDto();
        Set<ParticipantDto> participantDtoSet = participantFacade.getParticipantDtoSetByBillUuid(billUuid);

        Map<String, BigDecimal> map = new HashMap<>();
        for (ParticipantDto participantDto : participantDtoSet) {
            String uuid = participantDto.getUuid();
            BigDecimal bilans = submitParticipantBilans(uuid);
            map.put(uuid, bilans);
        }

        List<Map.Entry<String, BigDecimal>> participantsByBalance = map.entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .collect(Collectors.toList());

        int j = 1;
        int size = participantsByBalance.size();
        for (int i = 0; i < participantsByBalance.size(); i++) {

            BigDecimal front = participantsByBalance.get(i).getValue();
            BigDecimal back = participantsByBalance.get(size - j).getValue();


            if (back.abs().compareTo(front.abs()) >= 0) {
                participantsByBalance.get(i).setValue(BigDecimal.ZERO);
                participantsByBalance.get(size-j).setValue(back.add(front));
                result.addSuggestedTransfer(new SuggestedTransfer(participantsByBalance.get(size-j).getKey(), participantsByBalance.get(i).getKey(), front));
            } else {
                participantsByBalance.get(i).setValue(front.add(back));
                participantsByBalance.get(size-j).setValue(BigDecimal.ZERO);
                result.addSuggestedTransfer(new SuggestedTransfer(participantsByBalance.get(size-j).getKey(), participantsByBalance.get(i).getKey(), back));
                j++;
                i--;
            }
        }
        return result;
    }
}
