package com.shareExpenses.participant;

import com.shareExpenses.bill.Bill;
import com.shareExpenses.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Builder(builderMethodName = "create")
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Participant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "participant", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private Set<Contribution> contributions = new HashSet<>();
    @ManyToOne
    private Bill bill;
}