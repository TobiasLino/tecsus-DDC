package com.tecsus.ddc.bills.water.builders;

import com.tecsus.ddc.bills.Bill;
import com.tecsus.ddc.bills.water.WaterBill;
import com.tecsus.ddc.bills.water.enums.BillingType;
import com.tecsus.ddc.bills.water.enums.ConnectionType;

import java.math.BigDecimal;

public final class WaterBillBuilder {
    private WaterBill waterBill;

    private WaterBillBuilder() {
        waterBill = new WaterBill();
    }

    public static WaterBillBuilder aWaterBill() {
        return new WaterBillBuilder();
    }

    public WaterBillBuilder id(int id) {
        waterBill.setId(id);
        return this;
    }

    public WaterBillBuilder bill(Bill bill) {
        waterBill.setBill(bill);
        return this;
    }

    public WaterBillBuilder conType(ConnectionType conType) {
        waterBill.setConType(conType);
        return this;
    }

    public WaterBillBuilder billingType(BillingType billingType) {
        waterBill.setBillingType(billingType);
        return this;
    }

    public WaterBillBuilder consum(BigDecimal consum) {
        waterBill.setConsum(consum);
        return this;
    }

    public WaterBillBuilder water(BigDecimal water) {
        waterBill.setWater(water);
        return this;
    }

    public WaterBillBuilder sewer(BigDecimal sewer) {
        waterBill.setSewer(sewer);
        return this;
    }

    public WaterBillBuilder trcf(BigDecimal trcf) {
        waterBill.setTrcf(trcf);
        return this;
    }

    public WaterBillBuilder tributes(BigDecimal tributes) {
        waterBill.setTributes(tributes);
        return this;
    }

    public WaterBill build() {
        return waterBill;
    }
}
