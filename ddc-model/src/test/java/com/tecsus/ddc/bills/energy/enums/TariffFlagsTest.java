package com.tecsus.ddc.bills.energy.enums;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author TOBIASDASILVALINO
 */
public class TariffFlagsTest {

    @Test
    public void rightColorsTest() {
        TariffFlags t1 = TariffFlags.valueOf("VERDE");
        TariffFlags t2 = TariffFlags.valueOf("AMARELA");
        TariffFlags t3 = TariffFlags.valueOf("VERMELHA_1");
        TariffFlags t4 = TariffFlags.valueOf("VERMELHA_2");

        Assert.assertEquals(TariffFlags.VERDE,t1);
        Assert.assertEquals(TariffFlags.AMARELA,t2);
        Assert.assertEquals(TariffFlags.VERMELHA_1,t3);
        Assert.assertEquals(TariffFlags.VERMELHA_2,t4);
    }
}
