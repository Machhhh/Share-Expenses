package com.shareExpenses.bill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/bills")
class BillController {

    private BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping
    BillCreateDto create(@RequestBody BillCreateDto billCreateDto) {
        return billService.create(billCreateDto);
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