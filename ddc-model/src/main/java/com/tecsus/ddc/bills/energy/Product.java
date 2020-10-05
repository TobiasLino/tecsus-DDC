package com.tecsus.ddc.bills.energy;

import com.tecsus.ddc.bills.energy.enums.ProductDescription;

/**
 * @author TOBIASDASILVALINO
 */
public class Product {

    private double tariff;
    private double totalValue;
    private double kWhQuantity;
    private ProductDescription description;

    public Product(
            final ProductDescription description,
            final double kWhQuantity,
            final double tariff,
            final double totalValue) {
        this.tariff = tariff;
        this.totalValue = totalValue;
        this.kWhQuantity = kWhQuantity;
        this.description = description;
    }

    public double getTariff() {
        return tariff;
    }

    public void setTariff(final double tariff) {
        this.tariff = tariff;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(final double totalValue) {
        this.totalValue = totalValue;
    }

    public double getkWhQuantity() {
        return kWhQuantity;
    }

    public void setkWhQuantity(final double kWhQuantity) {
        this.kWhQuantity = kWhQuantity;
    }

    public ProductDescription getDescription() {
        return description;
    }

    public void setDescription(final ProductDescription description) {
        this.description = description;
    }
}
