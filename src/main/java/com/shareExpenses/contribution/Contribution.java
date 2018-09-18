package com.shareExpenses.contribution;

import com.shareExpenses.bill.Bill;
import com.shareExpenses.common.BaseEntity;
import com.shareExpenses.item.Item;
import com.shareExpenses.participant.Participant;
import lombok.*;

import javax.persistence.*;

@Builder(builderMethodName = "create")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Contribution extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Item item;
    @ManyToOne
    private Participant participant;
    @ManyToOne
    private Bill bill;
}