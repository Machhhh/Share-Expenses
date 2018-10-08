package com.shareExpenses.bill;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReportDto {

    List<SuggestedTransfer> suggestedTransfers = new ArrayList<>();


    void addSuggestedTransfer(SuggestedTransfer suggestedTransfer) {
        if (suggestedTransfer.getValue().compareTo(BigDecimal.ZERO) != 0) {
            this.suggestedTransfers.add(suggestedTransfer);
        }
    }

}
