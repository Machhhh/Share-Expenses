package com.shareExpenses.donation;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.Collection;
import java.util.Set;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface DonationMapper {
    @Mappings({
            @Mapping(source = "bill.uuid", target = "billNumber"),
            @Mapping(source = "participant.uuid", target = "participantUuid"),
            @Mapping(source = "participant.name", target = "participantName")
    })
    DonationDto toDonationDto(Donation donations);

    @Mappings({
            @Mapping(source = "bill.uuid", target = "billNumber"),
            @Mapping(source = "participant.uuid", target = "participantUuid")
    })
    DonationCreateDto toDonationCreateDto(Donation donations);

    Set<DonationDto> toDonationDtoSet(Collection<Donation> donations);
}

