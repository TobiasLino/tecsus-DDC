package com.tecsus.ddc.bills.energy;

import com.tecsus.ddc.bills.energy.enums.TariffFlags;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author TOBIASDASILVALINO
 */
public class EnergyBillTest {

    @Test
    public void energyBillHasTheCorrectFlagTest() {
        EnergyBill en = new EnergyBill();
        DateTime start = new DateTime().withDate(2020,10,1);
        DateTime finish = new DateTime().withDate(2020,10,4);
        TariffFlag green = new TariffFlag(TariffFlags.VERDE, start, finish);

        DateTime start1 = new DateTime().withDate(2020,10,5);
        DateTime finish1 = new DateTime().withDate(2020,10,20);
        TariffFlag yellow = new TariffFlag(TariffFlags.AMARELA, start1, finish1);

        DateTime start2 = new DateTime().withDate(2020,10,21);
        DateTime finish2 = new DateTime().withDate(2020,10,31);
        TariffFlag yellow2 = new TariffFlag(TariffFlags.AMARELA, start2, finish2);

        en.addTariffFlag(green);
        en.addTariffFlag(yellow);
        en.addTariffFlag(yellow2);

        List<TariffFlag> l1 = en.getTariffFlag(TariffFlags.VERDE);
        List<TariffFlag> l2 = en.getTariffFlag(TariffFlags.AMARELA);

        Assert.assertNotNull(l1);
        Assert.assertNotNull(l2);

        Assert.assertEquals(1, l1.size());
        Assert.assertEquals(2, l2.size());

        l1.stream().forEach(i -> {
            System.out.println(i.toString());
        });
        l2.stream().forEach(i -> {
            System.out.println(i.toString());
        });
    }

    @Test // TODO
    public void energyBuilderItsWorkingTest() {}
}
