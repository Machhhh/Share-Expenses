package com.shareExpenses.participant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/participants")
class ParticipantController {

    private ParticipantService participantService;

    @Autowired
    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @PostMapping
    ParticipantCreateDto create(@RequestBody ParticipantCreateDto participantCreateDto) {
        return participantService.create(participantCreateDto);
    }

    @GetMapping
    Set<ParticipantDto> getAllParticipants() {
        return participantService.findAll();
    }

    @GetMapping("/{uuid}")
    ParticipantDto findByUuid(@PathVariable String uuid) {
        return participantService.findOneByUuid(uuid);
    }

    @DeleteMapping("/{uuid}")
    void delete(@PathVariable String uuid) {
        participantService.deleteByUuid(uuid);
    }
}