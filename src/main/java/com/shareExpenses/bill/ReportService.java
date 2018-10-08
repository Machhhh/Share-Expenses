package com.shareExpenses.bill;

import java.math.BigDecimal;

interface ReportService {
    BigDecimal submitParticipantContribution(String uuid);
    BigDecimal submitParticipantBilans(String uuid);
    ReportDto report(String billUuid);
}
