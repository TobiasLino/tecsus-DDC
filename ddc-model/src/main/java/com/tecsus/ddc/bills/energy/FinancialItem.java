package com.tecsus.ddc.bills.energy;

import com.tecsus.ddc.bills.energy.enums.ProductDescription;

import java.math.BigDecimal;

/**
 * @author TOBIASDASILVALINO
 */
public class FinancialItem {

    private ProductDescription description;
    private BigDecimal value;

    public FinancialItem(final ProductDescription description, final BigDecimal value) {
        this.description = description;
        this.value = value;
    }

    public ProductDescription getDescription() {
        return description;
    }

    public void setDescription(final ProductDescription description) {
        this.description = description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(final BigDecimal value) {
        this.value = value;
    }
}
