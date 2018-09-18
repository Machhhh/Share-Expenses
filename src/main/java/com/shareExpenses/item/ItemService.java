package com.shareExpenses.item;

import java.util.Set;

interface ItemService {

    ItemCreateDto create(ItemCreateDto itemCreateDto);

    Set<ItemDto> findAll();

    ItemDto findOneByUuid(String uuid);

    Set<ItemDto> findAllByBillUuid(String uuid);

    Item findByUuid(String uuid);

    ItemDto findOneByName(String name);

    void delete(String uuid);
}