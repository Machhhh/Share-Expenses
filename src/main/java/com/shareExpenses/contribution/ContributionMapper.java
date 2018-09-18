package com.shareExpenses.contribution;

import com.shareExpenses.item.ItemMapper;
import com.shareExpenses.participant.ParticipantMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.Collection;
import java.util.Set;

@Mapper(componentModel = "spring", uses = {ParticipantMapper.class, ItemMapper.class},
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ContributionMapper {

    @Mappings({
            @Mapping(source = "participant.uuid", target = "participantUuid"),
            @Mapping(source = "participant.name", target = "participantName"),
            @Mapping(source = "item.uuid", target = "itemUuid"),
            @Mapping(source = "item.name", target = "itemName"),
            @Mapping(source = "bill.uuid", target = "billNumber")
    })
    ContributionDto toContributionDto(Contribution contribution);

    @Mappings({
            @Mapping(source = "participant.uuid", target = "participantUuid"),
            @Mapping(source = "item.uuid", target = "itemUuid"),
            @Mapping(source = "bill.uuid", target = "billNumber")
    })
    ContributionCreateDto toContributionCreateDto(Contribution contribution);

    Set<ContributionDto> toContributionDtoSet(Collection<Contribution> contributions);
}