package com.shareExpenses.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BillNotFoundException extends RuntimeException {
    String billNumber;
}
