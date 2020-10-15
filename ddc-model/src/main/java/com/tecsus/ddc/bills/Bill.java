package com.tecsus.ddc.bills;

import java.math.BigDecimal;

public class Bill {
    protected BigDecimal totalValue;  // R$

    public BigDecimal getTotalValue() {
        return null;
    }

    public void setTotalValue(final BigDecimal totalValue) {
        this.totalValue = totalValue;
    }
}
