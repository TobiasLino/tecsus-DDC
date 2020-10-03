package com.tecsus.ddc.bills.water;

import java.util.Objects;

/**
 * @author TOBIASDASILVALINO
 */
public class WaterBill {

    private long cod;
    private String hydrometer;
    private double residentialTotal;    // VI Água + VI Esgoto
    private int consumption;    // m3
    private double water;   // discriminação do faturamento
    private double sewer;   // discriminação do faturamento
    private double TRCF;   // discriminação do faturamento
    private String type;    // Ex: água e esgoto
    private String RGI;

    public WaterBill(
            long cod,
            String hydrometer,
            double residentialTotal,
            int consumption,
            double water,
            double sewer,
            double TRCF,
            String type,
            String RGI) {
        this.cod = cod;
        this.hydrometer = hydrometer;
        this.residentialTotal = residentialTotal;
        this.consumption = consumption;
        this.water = water;
        this.sewer = sewer;
        this.TRCF = TRCF;
        this.type = type;
        this.RGI = RGI;
    }

    // Just for test
    public WaterBill() {
    }

    @Override
    public String toString() {
        return "WaterBill{" +
                "cod=" + cod +
                ", hydrometer='" + hydrometer + '\'' +
                ", residentialTotal=" + residentialTotal +
                ", consumption=" + consumption +
                ", water=" + water +
                ", sewer=" + sewer +
                ", TRCF=" + TRCF +
                ", type='" + type + '\'' +
                ", RGI='" + RGI + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WaterBill waterBill = (WaterBill) o;
        return cod == waterBill.cod &&
                Double.compare(waterBill.residentialTotal, residentialTotal) == 0 &&
                consumption == waterBill.consumption &&
                Double.compare(waterBill.water, water) == 0 &&
                Double.compare(waterBill.sewer, sewer) == 0 &&
                Double.compare(waterBill.TRCF, TRCF) == 0 &&
                hydrometer.equals(waterBill.hydrometer) &&
                type.equals(waterBill.type) &&
                RGI.equals(waterBill.RGI);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cod, hydrometer, residentialTotal, consumption, water, sewer, TRCF, type, RGI);
    }

    public long getCod() {
        return cod;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }

    public String getHydrometer() {
        return hydrometer;
    }

    public void setHydrometer(String hydrometer) {
        this.hydrometer = hydrometer;
    }

    public double getResidentialTotal() {
        return residentialTotal;
    }

    public void setResidentialTotal(double residentialTotal) {
        this.residentialTotal = residentialTotal;
    }

    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }

    public double getWater() {
        return water;
    }

    public void setWater(double water) {
        this.water = water;
    }

    public double getSewer() {
        return sewer;
    }

    public void setSewer(double sewer) {
        this.sewer = sewer;
    }

    public double getTRCF() {
        return TRCF;
    }

    public void setTRCF(double TRCF) {
        this.TRCF = TRCF;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRGI() {
        return RGI;
    }

    public void setRGI(String RGI) {
        this.RGI = RGI;
    }
}
