package com.tecsus.ddc.bills.energy;

import com.tecsus.ddc.bills.energy.builders.ProductBuilder;
import com.tecsus.ddc.bills.energy.enums.ProductDescription;
import org.junit.Assert;
import org.junit.Test;

public class ProductTest {

    @Test
    public void productBuilderTest() {
        Product p = new ProductBuilder()
                .description(ProductDescription.RED_FLAG)
                .kWhQuantity(198.8437)
                .tariff(0.04)
                .totalValue(11.34)
                .build();

        Assert.assertEquals(0.04, p.getTariff(), 0.01);
        Assert.assertEquals(11.34, p.getTotalValue(), 0.01);
        Assert.assertEquals("Adicional bandeira Vermelha", p.getDescription().get());
        Assert.assertEquals(198.8437, p.getkWhQuantity(), 0.0001);
    }
}
