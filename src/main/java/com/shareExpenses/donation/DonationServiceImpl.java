package com.shareExpenses.donation;

import com.shareExpenses.bill.Bill;
import com.shareExpenses.bill.BillFacade;
import com.shareExpenses.participant.Participant;
import com.shareExpenses.participant.ParticipantFacade;
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
    private ParticipantFacade participantFacade;

    @Autowired
    public DonationServiceImpl(DonationRepository donationRepository,
                               DonationMapper donationMapper,
                               BillFacade billFacade,
                               ParticipantFacade participantFacade) {
        this.donationMapper = donationMapper;
        this.donationRepository = donationRepository;
        this.billFacade = billFacade;
        this.participantFacade = participantFacade;
    }

    @Override
    public DonationCreateDto create(DonationCreateDto dto) {
        Bill bill = billFacade.getBillByUuid(dto.getBillNumber());
        Participant participant = participantFacade.getParticipantByUuid(dto.getParticipantUuid());
        Donation donation = Donation.create()
                .bill(bill)
                .participant(participant)
                .Amount(dto.getAmount())
                .build();
        return donationMapper.toDonationCreateDto(donationRepository.save(donation));
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