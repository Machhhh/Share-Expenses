package com.shareExpenses.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Set;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private ItemService itemService;

    @Autowired
    ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    ItemDto createItem(@RequestBody ItemDto itemDto) {
        return itemService.create(itemDto);
    }

    @GetMapping
    Set<ItemDto> findAll() {
        return itemService.findAll();
    }

    @DeleteMapping("/{uuid}")
    void delete(@PathVariable String uuid) {
        itemService.delete(uuid);
    }

}
