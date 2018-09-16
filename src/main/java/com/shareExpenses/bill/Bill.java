package com.shareExpenses.bill;

import com.shareExpenses.common.BaseEntity;
import com.shareExpenses.participant.Participant;
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
public class Bill extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String linkName = "bill=" + name + getUuid().substring(0, 5);
    @OneToMany(mappedBy = "bill", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private Set<Item> items = new HashSet<>();
    @OneToMany(mappedBy = "bill", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private Set<Participant> participants = new HashSet<>();
    @OneToMany(mappedBy = "bill", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private Set<Contribution> contributions = new HashSet<>();
    @OneToMany(mappedBy = "bill", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private Set<Donation> donations = new HashSet<>();
}
