package com.shareExpenses.item;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;

@Component
public class ItemFacade {

    private ItemRepository itemRepository;
    private ItemMapper itemMapper;

    public ItemFacade(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public ItemDto getItemDtoByUuid(String uuid) {
        return itemMapper.toItemDto(itemRepository.findOneByUuid(uuid));
    }

    public ItemDto getItemDtoByName(String name) {
        return itemMapper.toItemDto(itemRepository.findOneByName(name));
    }

    public Set<ItemDto> getItemDtoSet() {
        return itemMapper.toItemDtoSet((Collection<Item>) itemRepository.findAll());
    }

    public Set<ItemDto> getItemDtoSetByBillUuid(String billUuid) {
        return itemMapper.toItemDtoSet(itemRepository.findAllByBillUuid(billUuid));
    }
}
