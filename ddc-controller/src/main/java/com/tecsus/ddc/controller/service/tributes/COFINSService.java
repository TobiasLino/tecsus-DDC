package com.tecsus.ddc.controller.service.tributes;

import com.tecsus.ddc.bills.tributes.Tribute;
import org.joda.time.DateTime;

public class COFINSService extends TributeService {

    private TributesConfig config;


    private COFINSService(Tribute cofins) {
        // this.config = new TributesConfig(Tributes.COFINS);
        super(cofins, 7, 4);
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
