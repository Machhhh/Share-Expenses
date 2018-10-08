package com.shareExpenses.item;

import com.shareExpenses.bill.Bill;
import com.shareExpenses.common.BaseEntity;
import com.shareExpenses.contribution.Contribution;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Builder(builderMethodName = "create")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private BigDecimal price;
    @OneToMany(mappedBy = "item", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private Set<Contribution> contributions = new HashSet<>();
    @ManyToOne
    private Bill bill;
}