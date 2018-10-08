package com.shareExpenses.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/items")
class ItemController {

    private ItemService itemService;

    @Autowired
    ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    ItemCreateDto create(@RequestBody ItemCreateDto itemCreateDto) {
        return itemService.create(itemCreateDto);
    }

    @GetMapping
    Set<ItemDto> getAllItems() {
        return itemService.findAll();
    }

    @GetMapping("/{uuid}")
    ItemDto findOneByUuid(@PathVariable String uuid) {
        return itemService.findOneByUuid(uuid);
    }

    @DeleteMapping("/{uuid}")
    void delete(@PathVariable String uuid) {
        itemService.delete(uuid);
    }
}