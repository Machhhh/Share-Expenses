package com.shareExpenses.bill;

import java.util.Set;

interface BillService {

    Set<BillDto> findAll();

    BillDto findOneByUuid(String uuid);

    BillCreateDto create(BillCreateDto billCreateDto);

    void deleteByUuid(String uuid);
}