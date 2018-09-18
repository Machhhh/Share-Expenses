package com.shareExpenses.donation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class DonationConfig {

    @Bean
    DonationFacade donationFacade(DonationService donationService) {
        return new DonationFacade(donationService);
    }
}