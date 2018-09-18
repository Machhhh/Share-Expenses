package com.shareExpenses.contribution;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContributionConfig {

    @Bean
    ContributionFacade contributionFacade(ContributionService contributionService) {
        return new ContributionFacade(contributionService);
    }
}