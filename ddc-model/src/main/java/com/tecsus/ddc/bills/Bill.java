package com.tecsus.ddc.bills;

import java.math.BigDecimal;

public abstract class Bill {
    protected BigDecimal totalValue;  // R$

    public abstract BigDecimal getTotalValue();

    public void setTotalValue(final BigDecimal totalValue) {
        this.totalValue = totalValue;
    }
}
