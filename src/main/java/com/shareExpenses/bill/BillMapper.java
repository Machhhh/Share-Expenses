package com.shareExpenses.bill;

import com.shareExpenses.contribution.ContributionMapper;
import com.shareExpenses.donation.DonationMapper;
import com.shareExpenses.item.ItemMapper;
import com.shareExpenses.participant.ParticipantMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.Collection;
import java.util.Set;

@Mapper(componentModel = "spring", uses = {ParticipantMapper.class, ContributionMapper.class,
        DonationMapper.class, ItemMapper.class}, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface BillMapper {

    @Mappings({
            @Mapping(source = "participants", target = "participantDtos"),
            @Mapping(source = "items", target = "itemDtos"),
            @Mapping(source = "contributions", target = "contributionDtos"),
            @Mapping(source = "donations", target = "donationDtos"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "uuid", target = "uuid")
    })
    BillDto toBillDto(Bill bill);

    @Mapping(source = "name", target = "name")
    BillCreateDto toBillCreateDto(Bill bill);

    Set<BillDto> toBillDtoSet(Collection<Bill> bills);
}