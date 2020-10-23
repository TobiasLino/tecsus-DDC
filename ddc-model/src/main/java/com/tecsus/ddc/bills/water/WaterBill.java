package com.tecsus.ddc.bills.water;

import com.tecsus.ddc.bills.Bill;
import com.tecsus.ddc.bills.water.enums.BillingType;
import com.tecsus.ddc.bills.water.enums.ConnectionType;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author TOBIASDASILVALINO
 */
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

    public WaterBill() {
    }

    @Override
    public String toString() {
        return "WaterBill{" +
                "id=" + id +
                ", bill=" + bill +
                ", conType=" + conType +
                ", billingType=" + billingType +
                ", consum=" + consum +
                ", water=" + water +
                ", sewer=" + sewer +
                ", trcf=" + trcf +
                ", tributes=" + tributes +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final WaterBill bill1 = (WaterBill) o;
        return id == bill1.id &&
                Objects.equals(bill, bill1.bill) &&
                conType == bill1.conType &&
                billingType == bill1.billingType &&
                Objects.equals(consum, bill1.consum) &&
                Objects.equals(water, bill1.water) &&
                Objects.equals(sewer, bill1.sewer) &&
                Objects.equals(trcf, bill1.trcf) &&
                Objects.equals(tributes, bill1.tributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bill, conType, billingType, consum, water, sewer, trcf, tributes);
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(final Bill bill) {
        this.bill = bill;
    }

    public ConnectionType getConType() {
        return conType;
    }

    public void setConType(final ConnectionType conType) {
        this.conType = conType;
    }

    public BillingType getBillingType() {
        return billingType;
    }

    public void setBillingType(final BillingType billingType) {
        this.billingType = billingType;
    }

    public BigDecimal getConsum() {
        return consum;
    }

    public void setConsum(final BigDecimal consum) {
        this.consum = consum;
    }

    public BigDecimal getWater() {
        return water;
    }

    public void setWater(final BigDecimal water) {
        this.water = water;
    }

    public BigDecimal getSewer() {
        return sewer;
    }

    public void setSewer(final BigDecimal sewer) {
        this.sewer = sewer;
    }

    public BigDecimal getTrcf() {
        return trcf;
    }

    public void setTrcf(final BigDecimal trcf) {
        this.trcf = trcf;
    }

    public BigDecimal getTributes() {
        return tributes;
    }

    public void setTributes(final BigDecimal tributes) {
        this.tributes = tributes;
    }
}
