package com.shareExpenses.participant;

import com.shareExpenses.contribution.ContributionMapper;
import com.shareExpenses.donation.DonationMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.Collection;
import java.util.Set;

    @Mapper(componentModel = "spring", uses = {ContributionMapper.class, DonationMapper.class},
            unmappedTargetPolicy = ReportingPolicy.ERROR)
    public interface ParticipantMapper {

        @Mappings({
                @Mapping(source = "contributions", target = "contributionDtos"),
                @Mapping(source = "donations", target = "donationDtos"),
                @Mapping(source = "bill.uuid", target = "billNumber")
        })
    ParticipantDto toParticipantDto(Participant participant);

    @Mapping(source = "bill.uuid", target = "billNumber")
    ParticipantCreateDto toParticipantCreateDto(Participant participant);

    Set<ParticipantDto> toParticipantDtoSet(Collection<Participant> participants);
}
