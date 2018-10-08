package com.shareExpenses.contribution;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/contributions")
class ContributionController {

    private ContributionService contributionService;

    @Autowired
    public ContributionController(ContributionService contributionService) {
        this.contributionService = contributionService;
    }

    @PostMapping
    ContributionCreateDto create(@RequestBody ContributionCreateDto contributionCreateDto) {
        return contributionService.create(contributionCreateDto);
    }

    @GetMapping
    Set<ContributionDto> getAllContributions() {
        return contributionService.findAll();
    }

    @GetMapping("/{uuid}")
    ContributionDto findByUuid(@PathVariable String uuid) {
        return contributionService.findOneByUuid(uuid);
    }

    @DeleteMapping("/{uuid}")
    void delete(@PathVariable String uuid) {
        contributionService.deleteByUuid(uuid);
    }
}