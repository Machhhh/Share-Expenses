package com.shareExpenses.donation;

import com.shareExpenses.bill.BillFacade;
import com.shareExpenses.participant.ParticipantFacade;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@AllArgsConstructor
@Getter
public class DonationFacade {

    private DonationRepository donationRepository;
    private DonationMapper donationMapper;
    private BillFacade billFacade;
    private ParticipantFacade participantFacade;

    public DonationDto getDonationDtoByUuid(String uuid) {
        return donationMapper.toDonationDto(donationRepository.findByUuid(uuid));
    }

    public Set<DonationDto> getDonationDtoSet() {
        return donationMapper.toDonationDtoSet(donationRepository.findAllBy());
    }

    public Set<DonationDto> getDonationDtoSetByBillUuid(String billUuid) {
        return donationMapper.toDonationDtoSet(donationRepository.findAllByBill_Uuid(billUuid));
    }
}