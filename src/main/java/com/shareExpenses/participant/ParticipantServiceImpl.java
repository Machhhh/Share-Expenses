package com.shareExpenses.participant;

import com.shareExpenses.bill.Bill;
import com.shareExpenses.bill.BillFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
@Transactional
class ParticipantServiceImpl implements ParticipantService {

    private ParticipantMapper participantMapper;
    private ParticipantRepository participantRepository;
    private BillFacade billFacade;

    @Autowired
    public ParticipantServiceImpl(ParticipantRepository participantRepository,
                                  ParticipantMapper participantMapper,
                                  BillFacade billFacade) {
        this.participantMapper = participantMapper;
        this.participantRepository = participantRepository;
        this.billFacade = billFacade;
    }

    @Override
    public ParticipantCreateDto create(ParticipantCreateDto dto) {
        Bill bill = billFacade.getBillByUuid(dto.getBillNumber());
        Participant participant = Participant.create()
                .name(dto.getName())
                .bill(bill)
                .build();
        return participantMapper.toParticipantCreateDto(participantRepository.save(participant));
    }

    @Override
    public Participant findByUuid(String uuid) {
        return participantRepository.findByUuid(uuid);
    }

    @Override
    public ParticipantDto findByname(String name) {
        return participantMapper.toParticipantDto(participantRepository.findByName(name));
    }

    @Override
    public Set<ParticipantDto> findAll() {
        return participantMapper.toParticipantDtoSet(participantRepository.findAllBy());
    }

    @Override
    public Set<ParticipantDto> findAllByBillUuid(String uuid) {
        return participantMapper.toParticipantDtoSet(participantRepository.findAllByBill_Uuid(uuid));
    }

    @Override
    public ParticipantDto findOneByUuid(String uuid) {
        return participantMapper.toParticipantDto(participantRepository.findByUuid(uuid));
    }

    @Override
    public void deleteByUuid(String uuid) {
        participantRepository.deleteByUuid(uuid);
    }
}