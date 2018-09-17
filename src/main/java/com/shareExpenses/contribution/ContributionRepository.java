package com.shareExpenses.contribution;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
interface ContributionRepository extends CrudRepository <Contribution,Long> {

    Set<Contribution> findAllBy();

    Contribution findByUuid(String uuid);

    Contribution findByName(String name);

    Set<Contribution> findAllByBill_Uuid(String uuid);

    void deleteByUuid(String uuid);
}
