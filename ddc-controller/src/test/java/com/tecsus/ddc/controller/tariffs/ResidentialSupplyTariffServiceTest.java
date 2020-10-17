package com.tecsus.ddc.controller.tariffs;

import com.tecsus.ddc.dealership.enums.EnergyDealerships;
import com.tecsus.ddc.tariffs.ResidentialSupplyTariff;
import org.junit.Test;
import com.tecsus.ddc.controller.service.tariffs.ResidentialSupllyTariffService;

import java.util.Optional;

/**
 * @author TOBIASDASILVALINO
 */
public class ResidentialSupplyTariffServiceTest {

    @Test
    public void constructTest() {
        Optional<ResidentialSupplyTariff> edp = new ResidentialSupllyTariffService(EnergyDealerships.EDP_SP)
                .construct()
                .create();

        if (!edp.isPresent()) {
            System.out.println("EDP is not present");
        } else {
            System.out.println(edp);
        }
    }
}
