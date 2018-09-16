package com.shareExpenses.bill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class BillFacade {

    private BillRepository billRepository;
    private BillMapper billMapper;

    @Autowired
    public BillFacade(BillRepository billRepository, BillMapper billMapper) {
        this.billRepository = billRepository;
        this.billMapper = billMapper;
    }

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
        return billMapper.toBillDtoSet(billRepository.findAllBy());
    }
}