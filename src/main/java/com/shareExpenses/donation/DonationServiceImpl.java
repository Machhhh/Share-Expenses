package com.shareExpenses.donation;

import com.shareExpenses.bill.Bill;
import com.shareExpenses.bill.BillFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;


@Service
@Transactional
class DonationServiceImpl implements DonationService {

    private DonationMapper donationMapper;
    private DonationRepository donationRepository;
    private BillFacade billFacade;

    @Autowired
    public DonationServiceImpl(DonationRepository donationRepository,
                               DonationMapper donationMapper,
                               BillFacade billFacade) {
        this.donationMapper = donationMapper;
        this.donationRepository = donationRepository;
        this.billFacade = billFacade;
    }

    @Override
    public DonationCreateDto create(DonationCreateDto donationCreateDto) {
        Bill bill = billFacade.getBillByUuid(donationCreateDto.getBillNumber());
        Donation donations = Donation.create()
                .name(donationCreateDto.getName())
                .bill(bill)
                .build();
        return donationMapper.toDonationCreateDto(donationRepository.save(donations));
    }

    @Override
    public Set<DonationDto> findAll() {
        return donationMapper.toDonationDtoSet(donationRepository.findAllBy());
    }

    @Override
    public Set<DonationDto> findAllByBillUuid(String uuid) {
        return donationMapper.toDonationDtoSet(donationRepository.findAllByBill_Uuid(uuid));
    }

    @Override
    public DonationDto findOneByUuid(String uuid) {
        return donationMapper.toDonationDto(donationRepository.findByUuid(uuid));
    }

    @Override
    public void deleteByUuid(String uuid) {
        donationRepository.deleteByUuid(uuid);
    }
}

