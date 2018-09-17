package com.shareExpenses.item;

import java.util.Set;

public interface ItemService {
    ItemDto create(ItemDto itemDto);
    Set<ItemDto> findAll();
    void delete(String uuid);
}
