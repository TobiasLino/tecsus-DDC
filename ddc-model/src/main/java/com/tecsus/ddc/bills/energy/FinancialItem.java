package com.tecsus.ddc.bills.energy;

import com.tecsus.ddc.bills.energy.enums.ProductDescription;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author TOBIASDASILVALINO
 */
@AllArgsConstructor
@Data
public class FinancialItem {

    private ProductDescription description;
    private BigDecimal value;
}
