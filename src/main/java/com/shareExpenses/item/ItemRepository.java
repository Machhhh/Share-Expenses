package com.shareExpenses.item;

import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ItemRepository extends CrudRepository<Item, Long> {
    Item findOneByUuid(String uuid);
    Item findOneByName(String name);
    Set<Item> findAllByBillUuid(String billUuid);
    void deleteByUuid(String uuid);
}
