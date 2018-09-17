package com.shareExpenses.bill;

import com.shareExpenses.participant.ParticipantMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.Collection;
import java.util.Set;

@Mapper(componentModel = "spring", uses = {ParticipantMapper.class, ContributionMapper.class,
        DonationMapper.class, ItemMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface BillMapper {

    @Mappings({
            @Mapping(source = "participants", target = "participantDtos"),
            @Mapping(source = "items", target = "itemDtos"),
            @Mapping(source = "contributions", target = "contributionDtos"),
            @Mapping(source = "donations", target = "donationDtos"),
    })
    BillDto toBillDto(Bill bill);

    Set<BillDto> toBillDtoSet(Collection<Bill> bills);
}