package com.shareExpenses.bill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
@Transactional
class BillServiceImpl implements BillService {

    private BillMapper billMapper;
    private BillRepository billRepository;

    @Autowired
    public BillServiceImpl(BillMapper billMapper, BillRepository billRepository) {
        this.billMapper = billMapper;
        this.billRepository = billRepository;
    }

    @Override
    public Set<BillDto> findAll() {
        return billMapper.toBillDtoSet(billRepository.findAll());
    }

    @Override
    public BillDto findOneByUuid(String uuid) {
        return billMapper.toBillDto(billRepository.findByUuid(uuid));
    }

    @Override
    public BillCreateDto create(BillCreateDto dto) {
        Bill bill = Bill.create()
                .name(dto.getName())
                .build();
        billRepository.save(bill);
        bill.setLinkName("bill=" + bill.getName() + bill.getUuid().substring(0, 5));
        return billMapper.toBillCreateDto(billRepository.save(bill));
    }

    @Override
    public void deleteByUuid(String uuid) {
        billRepository.deleteByUuid(uuid);
    }
}