package com.shareExpenses.bill;

import java.util.Set;

interface BillService {

    Set<BillDto> findAll();

    BillDto findOneByUuid(String uuid);

    Bill findByUuid(String uuid);

    BillDto getBillDtoByName(String name);

    BillCreateDto create(BillCreateDto billCreateDto);

    BillDto findByLinkName(String linkName);

    void deleteByUuid(String uuid);
}