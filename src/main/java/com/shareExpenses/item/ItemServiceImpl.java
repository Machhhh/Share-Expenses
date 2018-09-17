package com.shareExpenses.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Set;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;
    private ItemMapper itemMapper;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    @Override
    public ItemDto create(ItemDto itemDto) {
        Item item = Item.create().build();
        item = itemRepository.save(item);
        return itemMapper.toItemDto(itemRepository.save(item));
    }

    @Override
    public Set<ItemDto> findAll() {
        return itemMapper.toItemDtoSet((Collection<Item>) itemRepository.findAll());
    }

    @Override
    public void delete(String uuid) {
        itemRepository.deleteByUuid(uuid);
    }

}
