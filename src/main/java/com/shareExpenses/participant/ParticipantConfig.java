package com.shareExpenses.participant;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ParticipantConfig {

    @Bean
    ParticipantFacade participantFacade(ParticipantService participantService) {
        return new ParticipantFacade(participantService);
    }
}