package com.shareExpenses.participant;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.Collection;
import java.util.Set;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
interface ParticipantMapper {

    @Mapping(source = "bill.uuid", target = "billNumber")
    ParticipantDto toParticipantDto(Participant participant);

    @Mapping(source = "bill.uuid", target = "billNumber")
    ParticipantCreateDto toParticipantCreateDto(Participant participant);

    Set<ParticipantDto> toParticipantDtoSet(Collection<Participant> participants);
}
