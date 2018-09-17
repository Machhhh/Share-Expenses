package com.shareExpenses.donation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.Collection;
import java.util.Set;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public
interface DonationMapper {

    @Mapping(source = "bill.uuid", target = "billNumber")
    DonationDto toDonationDto(Donation donations);

    @Mapping(source = "bill.uuid", target = "billNumber")
    DonationCreateDto toDonationCreateDto(Donation donations);

    Set<DonationDto> toDonationDtoSet(Collection<Donation> donations);
}

