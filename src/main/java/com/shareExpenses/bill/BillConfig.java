package com.shareExpenses.bill;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class BillConfig {

    @Bean
    public BillFacade billFacade(BillRepository billRepository, BillMapper billMapper) {
        return new BillFacade(billRepository, billMapper);
    }
}