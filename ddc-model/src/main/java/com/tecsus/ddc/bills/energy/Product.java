package com.tecsus.ddc.bills.energy;

import com.tecsus.ddc.bills.energy.enums.ProductDescription;

import java.math.BigDecimal;

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
    private BigDecimal calcBasePISCOFINS;
    private BigDecimal aliqPIS;     // %
    private BigDecimal valuePIS;
    private BigDecimal aliqCOFINS;  // %
    private BigDecimal valueCOFINS;
    private BigDecimal totalValue;

    public Product(
            final ProductDescription description,
            final BigDecimal kWhQuantity,
            final BigDecimal tariff,
            final BigDecimal fornecValue,
            final BigDecimal tariffWithTributes,
            final BigDecimal calcBaseICMS,
            final BigDecimal aliqICMS,
            final BigDecimal valueICMS,
            final BigDecimal calcBasePISCOFINS,
            final BigDecimal aliqPIS,
            final BigDecimal valuePIS,
            final BigDecimal aliqCOFINS,
            final BigDecimal valueCOFINS,
            final BigDecimal totalValue) {
        this.description = description;
        this.kWhQuantity = kWhQuantity;
        this.tariff = tariff;
        this.fornecValue = fornecValue;
        this.tariffWithTributes = tariffWithTributes;
        this.calcBaseICMS = calcBaseICMS;
        this.aliqICMS = aliqICMS;
        this.valueICMS = valueICMS;
        this.calcBasePISCOFINS = calcBasePISCOFINS;
        this.aliqPIS = aliqPIS;
        this.valuePIS = valuePIS;
        this.aliqCOFINS = aliqCOFINS;
        this.valueCOFINS = valueCOFINS;
        this.totalValue = totalValue;
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

    public void setkWhQuantity(final BigDecimal kWhQuantity) {
        this.kWhQuantity = kWhQuantity;
    }

    public BigDecimal getTariff() {
        return tariff;
    }

    public void setTariff(final BigDecimal tariff) {
        this.tariff = tariff;
    }

    public BigDecimal getFornecValue() {
        return fornecValue;
    }

    public void setFornecValue(final BigDecimal fornecValue) {
        this.fornecValue = fornecValue;
    }

    public BigDecimal getTariffWithTributes() {
        return tariffWithTributes;
    }

    public void setTariffWithTributes(final BigDecimal tariffWithTributes) {
        this.tariffWithTributes = tariffWithTributes;
    }

    public BigDecimal getCalcBaseICMS() {
        return calcBaseICMS;
    }

    public void setCalcBaseICMS(final BigDecimal calcBaseICMS) {
        this.calcBaseICMS = calcBaseICMS;
    }

    public BigDecimal getAliqICMS() {
        return aliqICMS;
    }

    public void setAliqICMS(final BigDecimal aliqICMS) {
        this.aliqICMS = aliqICMS;
    }

    public BigDecimal getValueICMS() {
        return valueICMS;
    }

    public void setValueICMS(final BigDecimal valueICMS) {
        this.valueICMS = valueICMS;
    }

    public BigDecimal getCalcBasePISCOFINS() {
        return calcBasePISCOFINS;
    }

    public void setCalcBasePISCOFINS(final BigDecimal calcBasePISCOFINS) {
        this.calcBasePISCOFINS = calcBasePISCOFINS;
    }

    public BigDecimal getAliqPIS() {
        return aliqPIS;
    }

    public void setAliqPIS(final BigDecimal aliqPIS) {
        this.aliqPIS = aliqPIS;
    }

    public BigDecimal getValuePIS() {
        return valuePIS;
    }

    public void setValuePIS(final BigDecimal valuePIS) {
        this.valuePIS = valuePIS;
    }

    public BigDecimal getAliqCOFINS() {
        return aliqCOFINS;
    }

    public void setAliqCOFINS(final BigDecimal aliqCOFINS) {
        this.aliqCOFINS = aliqCOFINS;
    }

    public BigDecimal getValueCOFINS() {
        return valueCOFINS;
    }

    public void setValueCOFINS(final BigDecimal valueCOFINS) {
        this.valueCOFINS = valueCOFINS;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(final BigDecimal totalValue) {
        this.totalValue = totalValue;
    }
}
