package com.tecsus.ddc.bills.energy;

import com.tecsus.ddc.bills.energy.enums.TariffFlags;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author TOBIASDASILVALINO
 */
public class EnergyBillTest {

    @Test
    public void energyBillHasTheCorrectFlagTest() {
        EnergyBill en = new EnergyBill();
        en.setTariffFlag(TariffFlags.valueOf("VERDE"));

        Assert.assertEquals(TariffFlags.VERDE, en.getTariffFlag());
    }

    @Test // TODO
    public void energyBuilderItsWorkingTest() {}
}
