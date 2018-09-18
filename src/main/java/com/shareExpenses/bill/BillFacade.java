package com.shareExpenses.bill;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@AllArgsConstructor
@Getter
public class BillFacade {

    private BillRepository billRepository;
    private BillMapper billMapper;

    public Bill getBillByUuid(String uuid) {
        return billRepository.findByUuid(uuid);
    }

    public BillDto getBillDtoByName(String name) {
        return billMapper.toBillDto(billRepository.findByName(name));
    }

    public BillDto getBillDtoByUuid(String uuid) {
        return billMapper.toBillDto(billRepository.findByUuid(uuid));
    }

    public BillDto getBillDtoByLinkName(String linkName) {
        return billMapper.toBillDto(billRepository.findByLinkName(linkName));
    }

    public Set<BillDto> getBillDtoSet() {
        return billMapper.toBillDtoSet(billRepository.findAll());
    }
}