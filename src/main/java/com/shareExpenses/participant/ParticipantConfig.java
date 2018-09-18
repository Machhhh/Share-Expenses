package com.shareExpenses.participant;

import com.shareExpenses.bill.BillFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ParticipantConfig {

    @Bean
    ParticipantFacade participantFacade(ParticipantRepository repository,
                                        ParticipantMapper participantMapper,
                                        BillFacade billFacade) {
        return new ParticipantFacade(repository, participantMapper, billFacade);
    }
}