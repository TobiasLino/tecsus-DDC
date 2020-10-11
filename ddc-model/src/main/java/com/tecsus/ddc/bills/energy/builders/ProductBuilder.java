package com.tecsus.ddc.bills.energy.builders;

import com.tecsus.ddc.bills.energy.Product;
import com.tecsus.ddc.bills.energy.enums.ProductDescription;
import com.tecsus.ddc.bills.tributes.Tribute;

import java.math.BigDecimal;

/**
 * @author TOBIASDASILVALINO 
 */
public class ProductBuilder {
    
    private Product product;

    public ProductBuilder() {
        this.product = new Product();
    }

    public Product build() {
        return this.product;
    }

    public ProductBuilder description(final ProductDescription description) {
        this.product.setDescription(description);
        return this;
    }

    public ProductBuilder kWhQuantity(final String kWhQuantity) {
        this.product.setkWhQuantity(kWhQuantity);
        return this;
    }

    public ProductBuilder tariff(final String tariff) {
        this.product.setTariff(tariff);
        return this;
    }

    public ProductBuilder fornecValue(final String fornecValue) {
        this.product.setFornecValue(fornecValue);
        return this;
    }

    public ProductBuilder tariffWithTributes(final String tariffWithTributes) {
        this.product.setTariffWithTributes(tariffWithTributes);
        return this;
    }

    public ProductBuilder calcBaseICMS(final String calcBaseICMS) {
        this.product.setCalcBaseICMS(calcBaseICMS);
        return this;
    }

    public ProductBuilder aliqICMS(final String aliqICMS) {
        this.product.setAliqICMS(aliqICMS);
        return this;
    }

    public ProductBuilder pis(final Tribute pis) {
        this.product.setPIS(pis);
        return this;
    }

    public ProductBuilder cofins(final Tribute cofins) {
        this.product.setCOFINS(cofins);
        return this;
    }

    public ProductBuilder totalValue(final String totalValue) {
        this.product.setTotalValue(totalValue);
        return this;
    }
}
