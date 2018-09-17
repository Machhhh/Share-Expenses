package com.shareExpenses.participant;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
interface ParticipantRepository extends CrudRepository<Participant, Long> {

    Set<Participant> findAllBy();

    Participant findByUuid(String uuid);

    Participant findByName(String name);

    Set<Participant> findAllByBill_Uuid(String uuid);

    void deleteByUuid(String uuid);
}