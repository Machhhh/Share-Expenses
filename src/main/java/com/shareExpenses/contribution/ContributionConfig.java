package com.shareExpenses.contribution;

import com.shareExpenses.bill.BillFacade;
import com.shareExpenses.item.ItemFacade;
import com.shareExpenses.participant.ParticipantFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContributionConfig {

    @Bean
    ContributionFacade contributionFacade(ContributionRepository contributionRepository,
                                          ContributionMapper contributionMapper,
                                          BillFacade billFacade,
                                          ParticipantFacade participantFacade,
                                          ItemFacade itemFacade) {
        return new ContributionFacade(contributionRepository,
                contributionMapper,
                billFacade,
                participantFacade,
                itemFacade);
    }
}