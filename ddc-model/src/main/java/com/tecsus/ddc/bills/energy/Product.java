package com.tecsus.ddc.bills.energy;

import com.tecsus.ddc.bills.energy.enums.ProductDescription;
import com.tecsus.ddc.bills.tributes.Tribute;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author TOBIASDASILVALINO
 */
public class Product {

    private ProductDescription description;
    private BigDecimal kWhQuantity;
    private BigDecimal tariff;
    private BigDecimal fornecValue;
    private BigDecimal tariffWithTributes;
    private BigDecimal calcBaseICMS;
    private BigDecimal aliqICMS;    // %
    private BigDecimal valueICMS;
    private Tribute PIS;
    private Tribute COFINS;
    private BigDecimal totalValue;

    public Product() {
    }

    public Product(
            final ProductDescription description,
            final BigDecimal kWhQuantity,
            final BigDecimal tariff,
            final BigDecimal fornecValue,
            final BigDecimal tariffWithTributes,
            final BigDecimal calcBaseICMS,
            final BigDecimal aliqICMS,
            final BigDecimal valueICMS,
            final Tribute pis,
            final Tribute cofins,
            final BigDecimal totalValue) {
        this.description = description;
        this.kWhQuantity = kWhQuantity;
        this.tariff = tariff;
        this.fornecValue = fornecValue;
        this.tariffWithTributes = tariffWithTributes;
        this.calcBaseICMS = calcBaseICMS;
        this.aliqICMS = aliqICMS;
        this.valueICMS = valueICMS;
        this.PIS = pis;
        this.COFINS = cofins;
        this.totalValue = totalValue;
    }

    @Override
    public String toString() {
        return "Product{" +
                "description=" + description +
                ", kWhQuantity=" + kWhQuantity +
                ", tariff=" + tariff +
                ", fornecValue=" + fornecValue +
                ", tariffWithTributes=" + tariffWithTributes +
                ", calcBaseICMS=" + calcBaseICMS +
                ", aliqICMS=" + aliqICMS +
                ", valueICMS=" + valueICMS +
                ", PIS=" + PIS +
                ", COFINS=" + COFINS +
                ", totalValue=" + totalValue +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Product product = (Product) o;
        return description == product.description &&
                Objects.equals(kWhQuantity, product.kWhQuantity) &&
                Objects.equals(tariff, product.tariff) &&
                Objects.equals(fornecValue, product.fornecValue) &&
                Objects.equals(tariffWithTributes, product.tariffWithTributes) &&
                Objects.equals(calcBaseICMS, product.calcBaseICMS) &&
                Objects.equals(aliqICMS, product.aliqICMS) &&
                Objects.equals(valueICMS, product.valueICMS) &&
                Objects.equals(PIS, product.PIS) &&
                Objects.equals(COFINS, product.COFINS) &&
                Objects.equals(totalValue, product.totalValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, kWhQuantity, tariff, fornecValue, tariffWithTributes, calcBaseICMS, aliqICMS, valueICMS, PIS, COFINS, totalValue);
    }

    public ProductDescription getDescription() {
        return description;
    }

    public void setDescription(final ProductDescription description) {
        this.description = description;
    }

    public BigDecimal getkWhQuantity() {
        return kWhQuantity;
    }

    public void setkWhQuantity(final String kWhQuantity) {
        this.kWhQuantity = new BigDecimal(kWhQuantity);
    }

    public BigDecimal getTariff() {
        return tariff;
    }

    public void setTariff(final String tariff) {
        this.tariff = new BigDecimal(tariff);
    }

    public BigDecimal getFornecValue() {
        return fornecValue;
    }

    public void setFornecValue(final String fornecValue) {
        this.fornecValue = new BigDecimal(fornecValue);
    }

    public BigDecimal getTariffWithTributes() {
        return tariffWithTributes;
    }

    public void setTariffWithTributes(final String tariffWithTributes) {
        this.tariffWithTributes = new BigDecimal(tariffWithTributes);
    }

    public BigDecimal getCalcBaseICMS() {
        return calcBaseICMS;
    }

    public void setCalcBaseICMS(final String calcBaseICMS) {
        this.calcBaseICMS = new BigDecimal(calcBaseICMS);
    }

    public BigDecimal getAliqICMS() {
        return aliqICMS;
    }

    public void setAliqICMS(final String aliqICMS) {
        this.aliqICMS = new BigDecimal(aliqICMS);
    }

    public BigDecimal getValueICMS() {
        return valueICMS;
    }

    public void setValueICMS(final String valueICMS) {
        this.valueICMS = new BigDecimal(valueICMS);
    }

    public Tribute getPIS() {
        return PIS;
    }

    public void setPIS(final Tribute PIS) {
        this.PIS = PIS;
    }

    public Tribute getCOFINS() {
        return COFINS;
    }

    public void setCOFINS(final Tribute COFINS) {
        this.COFINS = COFINS;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(final String totalValue) {
        this.totalValue = new BigDecimal(totalValue);
    }
}
