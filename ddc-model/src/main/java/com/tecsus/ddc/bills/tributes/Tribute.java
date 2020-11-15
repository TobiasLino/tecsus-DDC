package com.tecsus.ddc.bills.tributes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Tribute {

    private Tributes description;
    private BigDecimal calcBase;
    private BigDecimal aliq;    // %
    private BigDecimal value;   // R$
}
