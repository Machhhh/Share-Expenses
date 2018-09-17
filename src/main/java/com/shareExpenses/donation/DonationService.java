package com.shareExpenses.donation;

import java.util.Set;


public interface DonationService {

    Set<DonationDto> findAll();

    DonationDto findOneByUuid(String uuid);

    Set<DonationDto> findAllByBillUuid(String uuid);

    DonationCreateDto create(DonationCreateDto dto);

    void deleteByUuid(String uuid);

}
