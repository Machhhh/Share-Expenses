package com.shareExpenses.bill;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
interface BillRepository extends CrudRepository<Bill, Long> {

    Bill findByUuid(String uuid);

    Set<Bill> findAll();

    Bill findByName(String name);

    Bill findByLinkName(String linkName);

    void deleteByUuid(String uuid);

}