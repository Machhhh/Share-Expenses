package com.shareExpenses.bill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
@Transactional
public class BillServiceImpl implements BillService {

    private BillMapper billMapper;
    private BillRepository billRepository;

    @Autowired
    public BillServiceImpl(BillMapper billMapper, BillRepository billRepository) {
        this.billMapper = billMapper;
        this.billRepository = billRepository;
    }

    @Override
    public Set<BillDto> findAll() {
        return billMapper.toBillDtoSet(billRepository.findAllBy());
    }

    @Override
    public BillDto findOneByUuid(String uuid) {
        return billMapper.toBillDto(billRepository.findByUuid(uuid));
    }

    @Override
    public BillDto create(BillDto dto) {
        return null;
    }

    @Override
    public void deleteByUuid(String uuid) {
        billRepository.deleteByUuid(uuid);
    }
}