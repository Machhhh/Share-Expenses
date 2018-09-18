package com.shareExpenses.donation;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@AllArgsConstructor
@Getter
public class DonationFacade {

    private DonationService donationService;

    public DonationDto getDonationDtoByUuid(String uuid) {
        return donationService.findOneByUuid(uuid);
    }

    public Set<DonationDto> getDonationDtoSet() {
        return donationService.findAll();
    }

    public Set<DonationDto> getDonationDtoSetByBillUuid(String billUuid) {
        return donationService.findAllByBillUuid(billUuid);
    }
}