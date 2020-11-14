package com.tecsus.ddc.bills.water;

import com.tecsus.ddc.bills.Bill;
import com.tecsus.ddc.bills.water.enums.BillingType;
import com.tecsus.ddc.bills.water.enums.ConnectionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author TOBIASDASILVALINO
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class WaterBill {

    private int id;
    private Bill bill;
    private ConnectionType conType;
    private BillingType billingType;
    private BigDecimal consum;  // m3
    private BigDecimal water;
    private BigDecimal sewer;
    private BigDecimal trcf;
    private BigDecimal tributes;
}
