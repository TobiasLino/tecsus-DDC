package com.tecsus.ddc.controller.tributes;

import com.tecsus.ddc.bills.energy.Product;
import com.tecsus.ddc.bills.energy.builders.ProductBuilder;
import com.tecsus.ddc.bills.energy.builders.TributeBuilder;
import com.tecsus.ddc.bills.energy.enums.ProductDescription;
import com.tecsus.ddc.bills.tributes.Tribute;
import com.tecsus.ddc.bills.tributes.Tributes;
import com.tecsus.ddc.controller.service.tributes.COFINSService;
import com.tecsus.ddc.controller.service.tributes.PISPASEPService;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author TOBIASDASILVALINO
 */
public class TributesTest {

    @Test
    public void cofinsServiceTest() {
        Tribute cofins = new Tribute();
        cofins.setCalcBase(new BigDecimal("255.97"));
        COFINSService service = COFINSService.createForMonth(
                new DateTime().withDate(2019, 8, 6), cofins);
        cofins.setAliq(service.calculateAliq());
        cofins.setValue(service.calulate());

        Assert.assertEquals("10.11",cofins.getValue().toString());
    }

    @Test
    public void pisPasepServiceTest() {
        Tribute pisPasep = new Tribute();
        pisPasep.setCalcBase(new BigDecimal("255.97"));
        PISPASEPService service = PISPASEPService.createForMonth(
                new DateTime().withDate(2019, 8, 6),
                pisPasep);

        pisPasep.setAliq(service.calculateAliq());
        pisPasep.setValue(service.calulate());

        Assert.assertEquals("2.20", pisPasep.getValue().toString());
    }

    @Test
    public void productTributesCalcTest() {
        DateTime month = new DateTime().withDate(2019, 8, 6);

        Product tusd = new ProductBuilder()
            .description(ProductDescription.TUSD)
            .kWhQuantity("303.0")
            .tariff("0.24174")
            .fornecValue("73.25")
            .tariffWithTributes("0.34442244")
            .calcBaseICMS("104.36")
            .aliqICMS("26.09")
            .pis(PISPASEPService.createPIS(
                    month,
                    new TributeBuilder()
                            .description(Tributes.PIS_PASEP)
                            .calcBase("104.36")
                            .build()
                    )
                )
            .cofins(COFINSService.createCOFINS(
                    month,
                    new TributeBuilder()
                        .description(Tributes.COFINS)
                        .calcBase("104.36")
                        .build()
                    )
                )
            .totalValue("104.36")
            .build();

        System.out.println(tusd);
    }
}
