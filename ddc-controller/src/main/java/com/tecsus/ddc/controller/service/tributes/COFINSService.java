package com.tecsus.ddc.controller.service.tributes;

import com.tecsus.ddc.bills.tributes.Tribute;
import com.tecsus.ddc.bills.tributes.Tributes;
import com.tecsus.ddc.controller.config.TributesConfig;
import org.joda.time.DateTime;

public class COFINSService extends TributeService {

    private COFINSService(Tribute cofins) {
        super(cofins, 7, 4);
        this.config = new TributesConfig(Tributes.COFINS);
    }

    public static COFINSService createForActualMonth(Tribute cofins) {
        COFINSService service = new COFINSService(cofins);
        service.period = new DateTime();
        service.construct(service.period);
        return service;
    }

    public static COFINSService createForMonth(DateTime period, Tribute cofins) {
        COFINSService service = new COFINSService(cofins);
        service.period = period;
        service.construct(period);
        return service;
    }

    public static Tribute createCOFINS(DateTime period, Tribute cofins) {
        COFINSService service = new COFINSService(cofins);
        service.period = period;
        service.construct(period);
        cofins.setAliq(service.calculateAliq());
        cofins.setValue(service.calulate());
        return cofins;
    }
}
