package com.shareExpenses.bill;

import java.util.Set;

interface BillService {

    Set<BillDto> findAll();

    BillDto findOneByUuid(String uuid);

    BillDto create(BillDto dto);

    void deleteByUuid(String uuid);
}