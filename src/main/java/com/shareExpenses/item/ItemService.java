package com.shareExpenses.item;

import java.util.Set;

interface ItemService {

    ItemCreateDto create(ItemCreateDto itemCreateDto);

    Set<ItemDto> findAll();

    ItemDto findOneByUuid(String uuid);

    void delete(String uuid);
}