package com.shareExpenses.donation;

import com.shareExpenses.bill.BillFacade;
import com.shareExpenses.participant.ParticipantFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class DonationConfig {

    @Bean
    DonationFacade donationFacade(DonationRepository donationRepository,
                                  DonationMapper donationMapper,
                                  BillFacade billFacade,
                                  ParticipantFacade participantFacade) {
        return new DonationFacade(donationRepository,
                donationMapper,
                billFacade,
                participantFacade);
    }
}