package com.shareExpenses.item;

import com.shareExpenses.bill.BillFacade;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collection;
import java.util.Set;

@AllArgsConstructor
@Getter
public class ItemFacade {

    private ItemRepository itemRepository;
    private ItemMapper itemMapper;
    private BillFacade billFacade;

    public Item getItemByUuid(String uuid) {
        return itemRepository.findByUuid(uuid);
    }

    public ItemDto getItemDtoByUuid(String uuid) {
        return itemMapper.toItemDto(itemRepository.findByUuid(uuid));
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