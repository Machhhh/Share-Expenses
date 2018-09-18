package com.shareExpenses.donation;

import com.shareExpenses.bill.Bill;
import com.shareExpenses.common.BaseEntity;
import com.shareExpenses.participant.Participant;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;


@Builder(builderMethodName = "create")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Donation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private BigDecimal Amount;
    @ManyToOne
    private Participant participant;
    @ManyToOne
    private Bill bill;
}