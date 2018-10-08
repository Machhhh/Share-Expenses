package com.shareExpenses.bill;

import com.shareExpenses.common.BaseEntity;
import com.shareExpenses.contribution.Contribution;
import com.shareExpenses.donation.Donation;
import com.shareExpenses.item.Item;
import com.shareExpenses.participant.Participant;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Builder(builderMethodName = "create")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Bill extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String name;
    private String linkName;
    @OneToMany(mappedBy = "bill", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private Set<Item> items = new HashSet<>();
    @OneToMany(mappedBy = "bill", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private Set<Participant> participants = new HashSet<>();
    @OneToMany(mappedBy = "bill", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private Set<Contribution> contributions = new HashSet<>();
    @OneToMany(mappedBy = "bill", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private Set<Donation> donations = new HashSet<>();
}
