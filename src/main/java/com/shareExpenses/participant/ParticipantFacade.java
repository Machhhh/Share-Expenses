package com.shareExpenses.participant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ParticipantFacade {

    private ParticipantRepository participantRepository;
    private ParticipantMapper participantMapper;

    @Autowired
    public ParticipantFacade(ParticipantRepository participantRepository,
                             ParticipantMapper participantMapper) {
        this.participantRepository = participantRepository;
        this.participantMapper = participantMapper;
    }

    public ParticipantDto getParticipantDtoByUuid(String uuid) {
        return participantMapper.toParticipantDto(participantRepository.findByUuid(uuid));
    }

    public ParticipantDto getParticipantDtoByName(String name) {
        return participantMapper.toParticipantDto(participantRepository.findByName(name));
    }

    public Set<ParticipantDto> getParticipantDtoSet() {
        return participantMapper.toParticipantDtoSet(participantRepository.findAllBy());
    }

    public Set<ParticipantDto> getParticipantDtoSetByBillUuid(String billUuid) {
        return participantMapper.toParticipantDtoSet(participantRepository.findAllByBill_Uuid(billUuid));
    }
}