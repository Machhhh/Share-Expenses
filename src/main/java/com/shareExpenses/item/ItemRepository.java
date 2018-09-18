package com.shareExpenses.item;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
interface ItemRepository extends CrudRepository<Item, Long> {

    Item findByUuid(String uuid);

    Item findOneByName(String name);

    Set<Item> findAll();

    Set<Item> findAllByBillUuid(String uuid);

    void deleteByUuid(String uuid);
}