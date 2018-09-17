package com.shareExpenses.participant;

import java.util.Set;

interface ParticipantService {

    Set<ParticipantDto> findAll();

    ParticipantDto findOneByUuid(String uuid);

    Set<ParticipantDto> findAllByBillUuid(String uuid);

    ParticipantCreateDto create(ParticipantCreateDto dto);

    void deleteByUuid(String uuid);
}