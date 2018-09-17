package com.shareExpenses.contribution;

import com.shareExpenses.common.BaseEntity;
import com.shareExpenses.item.Item;
import com.shareExpenses.participant.Participant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder(builderMethodName = "create")
@Getter
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

}
