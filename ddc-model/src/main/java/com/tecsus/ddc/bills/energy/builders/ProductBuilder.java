package com.tecsus.ddc.bills.energy.builders;

import com.tecsus.ddc.bills.energy.Product;
import com.tecsus.ddc.bills.energy.enums.ProductDescription;

/**
 * @author TOBIASDASILVALINO
 */
public class ProductBuilder {

    private double tariff;
    private double totalValue;
    private double kWhQuantity;
    private ProductDescription description;

    public Product build() {
        return new Product(description, kWhQuantity, tariff, totalValue);
    }

    public ProductBuilder tariff(final double tariff) {
        this.tariff = tariff;
        return this;
    }

    public ProductBuilder totalValue(final double totalValue) {
        this.totalValue = totalValue;
        return this;
    }

    public ProductBuilder kWhQuantity(final double kWhQuantity) {
        this.kWhQuantity = kWhQuantity;
        return this;
    }

    public ProductBuilder description(final ProductDescription description) {
        this.description = description;
        return this;
    }
}
