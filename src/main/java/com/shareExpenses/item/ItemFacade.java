package com.shareExpenses.item;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@AllArgsConstructor
@Getter
public class ItemFacade {

    private ItemService itemService;

    public Item getItemByUuid(String uuid) {
        return itemService.findByUuid(uuid);
    }

    public ItemDto getItemDtoByUuid(String uuid) {
        return itemService.findOneByUuid(uuid);
    }

    public ItemDto getItemDtoByName(String name) {
        return itemService.findOneByName(name);
    }

    public Set<ItemDto> getItemDtoSet() {
        return itemService.findAll();
    }

    public Set<ItemDto> getItemDtoSetByBillUuid(String billUuid) {
        return itemService.findAllByBillUuid(billUuid);
    }
}