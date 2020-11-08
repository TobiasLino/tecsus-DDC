package com.tecsus.ddc.query;

import com.tecsus.ddc.bills.Bill;
import com.tecsus.ddc.bills.builders.BillBuilder;
import com.tecsus.ddc.bills.energy.EnergyBill;
import com.tecsus.ddc.bills.energy.builders.EnergyBillBuilder;
import org.joda.time.DateTime;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EnergyBillQueryFactoryTest {

    @Test
    public void testaSeAQueryEstaSendoFormada(){
        String querySimples = insertQuerySimples();
        EnergyBill energyBill = simpleEnergyBill();

        assertNotNull(energyBill);
    }

    private EnergyBill simpleEnergyBill() {
        return EnergyBillBuilder.anEnergyBill()
                .bill(new BillBuilder().numConta("465798546").build())
                .consumption(new BigDecimal("50.03"))
                .tension(220)
                .emission(new DateTime().withDate(2020,02,02))
                .build();
    }

    private String insertQuerySimples(){
        return "INSERT INTO energy_bill  ( "+
                "abs_bill, consum_khw, tension, emission, icms, tributes, financ_items, supply, en_group, "+
                "en_sub_group, en_class, en_sub_class, en_modalitie) VALUES ('" +
                "465798546'," +
                "50.03," +
                "220," +
                "TO_DATE('2020/02/02', 'YYYY/MM/DD'), " +
                "1.09 ," +
                "30.02," +
                "0," +
                "'BIFASICO'," +
                "'B'," +
                "'B2'," +
                "'RESIDENCIAL'," +
                "'RESIDENCIAL'," +
                "'VERDE')";
    }
}
