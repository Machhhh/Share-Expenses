package com.shareExpenses.item;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ItemConfig {

    @Bean
    public ItemFacade itemFacade(ItemService itemService) {
        return new ItemFacade(itemService);
    }
}