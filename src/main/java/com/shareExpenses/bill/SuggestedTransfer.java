package com.shareExpenses.bill;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SuggestedTransfer {

    private String from;
    private String to;
    private BigDecimal value;
}
