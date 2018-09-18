package com.shareExpenses.item;

import com.shareExpenses.contribution.ContributionMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.Collection;
import java.util.Set;

@Mapper(componentModel = "spring", uses = {ContributionMapper.class},
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ItemMapper {

    @Mappings({
            @Mapping(source = "contributions", target = "contributionDtos"),
            @Mapping(source = "bill.uuid", target = "billNumber")
    })
    ItemDto toItemDto(Item item);

    @Mapping(source = "bill.uuid", target = "billNumber")
    ItemCreateDto toItemCreateDto(Item item);

    Set<ItemDto> toItemDtoSet(Collection<Item> items);
}