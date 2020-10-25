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
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author TOBIASDASILVALINO
 */
public class TributesTest {

    //@Test
    public void cofinsServiceTest() {
        Tribute cofins = new Tribute();
        cofins.setCalcBase(new BigDecimal("255.97"));
        COFINSService service = COFINSService.createForMonth(
                new DateTime().withDate(2019, 8, 6), cofins);
        cofins.setAliq(service.calculateAliq());
        cofins.setValue(service.calulate());

        assertEquals("10.11",cofins.getValue().toString());
    }

//    @Test
    public void pisPasepServiceTest() {
        Tribute pisPasep = new Tribute();
        pisPasep.setCalcBase(new BigDecimal("255.97"));
        PISPASEPService service = PISPASEPService.createForMonth(
                new DateTime().withDate(2019, 8, 6),
                pisPasep);

        pisPasep.setAliq(service.calculateAliq());
        pisPasep.setValue(service.calulate());

        assertEquals("2.20", pisPasep.getValue().toString());
    }
}
