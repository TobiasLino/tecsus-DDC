package com.tecsus.ddc.bills.energy.enums;

import org.junit.Assert;
import org.junit.Test;

public class ProductDescriptionTest {

    @Test
    public void getDescriptionTest() {
        ProductDescription pd = ProductDescription.YELLOW_FLAG;
        Assert.assertEquals("Adicional Bandeira Amarela", pd.getDescription());
    }
}
