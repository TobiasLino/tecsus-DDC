package com.tecsus.ddc.bills.water.builders;

import com.tecsus.ddc.bills.water.WaterBill;
import com.tecsus.ddc.bills.water.enums.WaterBillType;

/**
 * @author TOBIASDASILVALINO
 */
public class WaterBillBuilder {

    private long cod;
    private String hydrometer;
    private double residentialTotal;    // VI Água + VI Esgoto
    private int consumption;    // m3
    private double water;   // discriminação do faturamento
    private double sewer;   // discriminação do faturamento
    private double TRCF;   // discriminação do faturamento
    private WaterBillType type;    // Ex: água e esgoto
    private String RGI;
    
    public WaterBill build() {
        return new WaterBill(cod, hydrometer, residentialTotal, consumption, water, sewer, TRCF, type, RGI);
    }

    public WaterBillBuilder cod(long cod) {
        this.cod = cod;
        return this;
    }

    public WaterBillBuilder hydrometer(String hydrometer) {
        this.hydrometer = hydrometer;
        return this;
    }

    public WaterBillBuilder residentialTotal(double residentialTotal) {
        this.residentialTotal = residentialTotal;
        return this;
    }

    public WaterBillBuilder consumption(int consumption) {
        this.consumption = consumption;
        return this;
    }

    public WaterBillBuilder water(double water) {
        this.water = water;
        return this;
    }

    public WaterBillBuilder sewer(double sewer) {
        this.sewer = sewer;
        return this;
    }

    public WaterBillBuilder TRCF(double TRCF) {
        this.TRCF = TRCF;
        return this;
    }

    public WaterBillBuilder type(WaterBillType type) {
        this.type = type;
        return this;
    }

    public WaterBillBuilder RGI(String RGI) {
        this.RGI = RGI;
        return this;
    }
}
