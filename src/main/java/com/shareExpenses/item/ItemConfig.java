package com.shareExpenses.item;

import com.shareExpenses.bill.BillFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ItemConfig {

    @Bean
    public ItemFacade itemFacade(ItemRepository itemRepository, ItemMapper itemMapper,
                          BillFacade billFacade) {
        return new ItemFacade(itemRepository, itemMapper, billFacade);
    }
}