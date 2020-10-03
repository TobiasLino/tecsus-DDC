package com.tecsus.ddc.bills.water;

import com.tecsus.ddc.bills.water.builders.WaterBillBuilder;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author TOBIASDASILVALINO
 */
public class WaterBillTest {

    @Test
    public void waterBillTest() {
        WaterBill wb = new WaterBill();

        Assert.assertNotNull(wb);
    }

    @Test
    public void waterBillBuilderTest() {
        WaterBill wb = new WaterBillBuilder()
                .cod(123456)
                .RGI("1111/23")
                .build();

        Assert.assertEquals(123456, wb.getCod());
        Assert.assertEquals("1111/23", wb.getRGI());
    }
}
