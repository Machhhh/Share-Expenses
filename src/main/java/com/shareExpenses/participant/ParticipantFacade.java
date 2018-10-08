package com.shareExpenses.participant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@AllArgsConstructor
@Getter
public class ParticipantFacade {

    private ParticipantService participantService;

    public Participant getParticipantByUuid(String uuid) {
        return participantService.findByUuid(uuid);
    }

    public ParticipantDto getParticipantDtoByUuid(String uuid) {
        return participantService.findOneByUuid(uuid);
    }

    public ParticipantDto getParticipantDtoByName(String name) {
        return participantService.findByname(name);
    }

    public Set<ParticipantDto> getParticipantDtoSet() {
        return participantService.findAll();
    }

    public Set<ParticipantDto> getParticipantDtoSetByBillUuid(String billUuid) {
        return participantService.findAllByBillUuid(billUuid);
    }
}