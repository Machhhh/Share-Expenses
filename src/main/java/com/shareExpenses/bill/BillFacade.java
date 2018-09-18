package com.shareExpenses.bill;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@AllArgsConstructor
@Getter
public class BillFacade {

    private BillService billService;

    public Bill getBillByUuid(String uuid) {
        return billService.findByUuid(uuid);
    }

    public BillDto getBillDtoByName(String name) {
        return billService.getBillDtoByName(name);
    }

    public BillDto getBillDtoByUuid(String uuid) {
        return billService.findOneByUuid(uuid);
    }

    public BillDto getBillDtoByLinkName(String linkName) {
        return billService.findByLinkName(linkName);
    }

    public Set<BillDto> getBillDtoSet() {
        return billService.findAll();
    }
}