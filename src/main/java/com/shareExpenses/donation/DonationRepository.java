package com.shareExpenses.donation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Set;

@Repository
interface DonationRepository extends CrudRepository<Donation, Long> {

    Set<Donation> findAllBy();

    Donation findByUuid(String uuid);

    Donation findByName(String name);

    Donation findByAmmount(BigDecimal Ammount);

    Set<Donation> findAllByBill_Uuid(String uuid);

    void deleteByUuid(String uuid);
}
