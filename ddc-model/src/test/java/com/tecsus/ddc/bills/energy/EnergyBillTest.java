package com.tecsus.ddc.bills.energy;

import com.tecsus.ddc.bills.energy.builders.EnergyBillBuilder;
import com.tecsus.ddc.bills.energy.builders.ProductBuilder;
import com.tecsus.ddc.bills.energy.builders.TariffFlagBuilder;
import com.tecsus.ddc.bills.energy.enums.ProductDescription;
import com.tecsus.ddc.bills.energy.enums.TariffFlags;
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

        TariffFlag green = new TariffFlagBuilder()
                .flag(TariffFlags.VERDE)
                .start(1, 10, 2020)
                .finish(4, 10, 2020)
                .build();

        TariffFlag yellow = new TariffFlagBuilder()
                .flag(TariffFlags.AMARELA)
                .start(5, 10, 2020)
                .finish(20, 10, 2020)
                .build();

        TariffFlag yellow2 = new TariffFlagBuilder()
                .flag(TariffFlags.AMARELA)
                .start(21, 10, 2020)
                .finish(31, 10, 2020)
                .build();

        en.addTariffFlag(green);
        en.addTariffFlag(yellow);
        en.addTariffFlag(yellow2);

        List<TariffFlag> l1 = en.getTariffFlag(TariffFlags.VERDE);
        List<TariffFlag> l2 = en.getTariffFlag(TariffFlags.AMARELA);

        Assert.assertNotNull(l1);
        Assert.assertNotNull(l2);

        Assert.assertEquals(1, l1.size());
        Assert.assertEquals(2, l2.size());

        l1.forEach(i -> {
            System.out.println(i.toString());
        });
        l2.forEach(i -> {
            System.out.println(i.toString());
        });
    }

    @Test // TODO
    public void energyBillBuilderItsWorkingTest() {}

    public void energyBillProductsTest() {
        EnergyBill en = new EnergyBill();

        Product tusd = new ProductBuilder()
                .description(ProductDescription.TUSD)
                .kWhQuantity(303)
                .tariff(0.24174)
                .totalValue(104.36)
                .build();
        Product te = new ProductBuilder()
                .description(ProductDescription.TE)
                .kWhQuantity(303)
                .tariff(0.31979)
                .totalValue(138.05)
                .build();

        Product addYellow = new ProductBuilder()
                .description(ProductDescription.YELLOW_FLAG)
                .kWhQuantity(104.1563)
                .tariff(0.015)
                .totalValue(2.22)
                .build();

        Product addRed = new ProductBuilder()
                .description(ProductDescription.RED_FLAG)
                .kWhQuantity(198.8437)
                .tariff(0.04)
                .totalValue(11.34)
                .build();

        en.addProduct(tusd);
        en.addProduct(te);
        en.addProduct(addYellow);
        en.addProduct(addRed);

        double total = en.getProducts().stream().mapToDouble(Product::getTotalValue).sum();

        Assert.assertEquals(4, en.getProducts().size());
        Assert.assertEquals(255.97, total, 0.01);
    }
}
