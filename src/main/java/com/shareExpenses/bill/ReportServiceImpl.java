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
        Set<ParticipantDto> participantDtoSet = participantFacade.getParticipantDtoSet();
        Map<String, BigDecimal> map = new HashMap<>();
        List<Map.Entry<String, BigDecimal>> entriesSortedByValue = map.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .collect(Collectors.toList());
        for (ParticipantDto participantDto: participantDtoSet) {
            String uuid = participantDto.getUuid();
            BigDecimal bilans = submitParticipantBilans(uuid);
            map.put(uuid, bilans);
        }
        for (int i = 0; i < entriesSortedByValue.size(); i++) {
/*            if(entriesSortedByValue.get(i).getValue().equals(new BigDecimal(0))) {
                entriesSortedByValue.remove(i);
            }*/
            int j = 1;
            entriesSortedByValue.get(entriesSortedByValue.size()-j).getValue().add(entriesSortedByValue.get(i).getValue());
            entriesSortedByValue.get(i).getValue().subtract(entriesSortedByValue.get(i).getValue());
            if (entriesSortedByValue.get(entriesSortedByValue.size()-j).getValue().equals(new BigDecimal(0))) {
                j++;
            }
        }
        return new ReportDto();
    }

}
