package com.shareExpenses.donation;

import com.shareExpenses.bill.Bill;
import com.shareExpenses.common.BaseEntity;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


    @Builder(builderMethodName = "create")
    @Getter
    @Entity
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class Donation extends BaseEntity {


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        @Column(unique = true)
        private String name;
        @OneToMany(mappedBy = "participant", cascade = {CascadeType.ALL}, orphanRemoval = true)
        private Set<Donation> donations = new HashSet<>();
        @ManyToOne
        private Bill bill;
    }




