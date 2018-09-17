package com.shareExpenses.item;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;

@Builder(builderMethodName = "create")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.PROTECTED)
    private Long id;
    private String name;
    private BigDecimal price;
    @OneToMany(mappedBy = "item", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private Set<Contribution> contributions = new HashSet<>();
    @ManyToOne
    private Bill bill;
}
