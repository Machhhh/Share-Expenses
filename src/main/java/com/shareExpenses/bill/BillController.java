package com.shareExpenses.bill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/bills")
public class BillController {

    private BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping
    BillDto create(@RequestBody BillDto billDto) {
        return billService.create(billDto);
    }

    @GetMapping
    Set<BillDto> getAllBills() {
        return billService.findAll();
    }

    @GetMapping("/{uuid}")
    BillDto findByUuid(@PathVariable String uuid) {
        return billService.findOneByUuid(uuid);
    }

    @DeleteMapping("/{uuid}")
    void delete(@PathVariable String uuid) {
        billService.deleteByUuid(uuid);
    }
}