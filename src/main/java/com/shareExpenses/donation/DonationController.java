package com.shareExpenses.donation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/donations")
public class DonationController {

    private DonationService donationService;

    @Autowired
    public DonationController(DonationService donationService) {
        this.donationService = donationService;
    }

    @PostMapping
    DonationCreateDto create(@RequestBody DonationCreateDto donationCreateDto) {
        return donationService.create(donationCreateDto);
    }

    @GetMapping
    Set<DonationDto> getAllDonations() {
        return donationService.findAll();
    }

    @GetMapping("/{uuid}")
    DonationDto findByUuid(@PathVariable String uuid) {
        return donationService.findOneByUuid(uuid);
    }

    @DeleteMapping("/{uuid}")
    void delete(@PathVariable String uuid) {
        donationService.deleteByUuid(uuid);
    }

}
