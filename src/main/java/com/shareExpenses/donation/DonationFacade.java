package com.shareExpenses.donation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DonationFacade {
    private DonationRepository donationRepository;
    private DonationMapper donationMapper;

    @Autowired
    public DonationFacade(DonationRepository donationRepository,
                             DonationMapper donationMapper) {
        this.donationRepository = donationRepository;
        this.donationMapper = donationMapper;
    }

    public DonationDto getDonationDtoByUuid(String uuid) {
        return donationMapper.toDonationDto(donationRepository.findByUuid(uuid));
    }

    public DonationDto getDonationDtoByName(String name) {
        return donationMapper.toDonationDto(donationRepository.findByName(name));
    }

    public Set<DonationDto> getParticipantDtoSet() {
        return donationMapper.toDonationDtoSet(donationRepository.findAllBy());
    }

    public Set<DonationDto> getParticipantDtoSetByBillUuid(String billUuid) {
        return donationMapper.toDonationDtoSet(donationRepository.findAllByBill_Uuid(billUuid));
    }
}
