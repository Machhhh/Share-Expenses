package com.shareExpenses.item;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.Collection;
import java.util.Set;

@Mapper(componentModel = "spring", uses = {Contribution.class}, unmappedTargetPolicy = ReportingPolicy.ERROR)
interface ItemMapper {

    @Mappings({
            @Mapping(source = "id", target = "userId"),
            @Mapping(source = "name", target = "userName")
    })
    ItemDto toItemDto(Item item);

    Set<ItemDto> toItemDtoSet(Collection<Item> items);

}
