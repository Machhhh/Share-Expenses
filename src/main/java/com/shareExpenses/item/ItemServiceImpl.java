package com.shareExpenses.item;

import com.shareExpenses.bill.Bill;
import com.shareExpenses.bill.BillFacade;
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
    private BillFacade billFacade;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, ItemMapper itemMapper,
                           BillFacade billFacade) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
        this.billFacade = billFacade;
    }

    @Override
    public ItemCreateDto create(ItemCreateDto dto) {
        Bill bill = billFacade.getBillByUuid(dto.getBillNumber());
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
    public Item findByUuid(String uuid) {
        return itemRepository.findByUuid(uuid);
    }

    @Override
    public Set<ItemDto> findAllByBillUuid(String uuid) {
        return itemMapper.toItemDtoSet(itemRepository.findAllByBillUuid(uuid));
    }

    @Override
    public ItemDto findOneByName(String name) {
        return itemMapper.toItemDto(itemRepository.findOneByName(name));
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