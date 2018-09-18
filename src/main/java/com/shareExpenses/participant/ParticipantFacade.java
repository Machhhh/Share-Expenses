package com.shareExpenses.participant;

import com.shareExpenses.bill.BillFacade;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@AllArgsConstructor
@Getter
public class ParticipantFacade {

    private ParticipantRepository participantRepository;
    private ParticipantMapper participantMapper;
    private BillFacade billFacade;

    public Participant getParticipantByUuid(String uuid) {
        return participantRepository.findByUuid(uuid);
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