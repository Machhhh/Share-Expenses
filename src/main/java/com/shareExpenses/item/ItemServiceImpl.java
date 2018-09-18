package com.shareExpenses.item;

import com.shareExpenses.bill.Bill;
import com.shareExpenses.exceptions.BillNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;
    private ItemMapper itemMapper;
    private ItemFacade itemFacade;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, ItemMapper itemMapper,
                           ItemFacade itemFacade) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
        this.itemFacade = itemFacade;
    }

    @Override
    public ItemCreateDto create(ItemCreateDto dto) {
        Bill bill = itemFacade.getBillFacade().getBillByUuid(dto.getBillNumber());
        if (bill == null) {
            throw new BillNotFoundException(dto.getBillNumber());
        }
        Item item = Item.create()
                .name(dto.getName())
                .bill(bill)
                .price(dto.getPrice())
                .build();
        return itemMapper.toItemCreateDto(itemRepository.save(item));
    }

    @Override
    public ItemDto findOneByUuid(String uuid) {
        return itemMapper.toItemDto(itemRepository.findByUuid(uuid));
    }

    @Override
    public Set<ItemDto> findAll() {
        return itemMapper.toItemDtoSet(itemRepository.findAll());
    }

    @Override
    public void delete(String uuid) {
        itemRepository.deleteByUuid(uuid);
    }
}