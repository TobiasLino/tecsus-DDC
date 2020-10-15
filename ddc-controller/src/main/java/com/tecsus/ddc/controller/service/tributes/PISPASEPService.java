package com.tecsus.ddc.controller.service.tributes;

import com.tecsus.ddc.bills.tributes.Tribute;
import com.tecsus.ddc.bills.tributes.Tributes;
import com.tecsus.ddc.controller.config.TributesConfig;
import org.joda.time.DateTime;

public class PISPASEPService extends TributeService {
    
    private PISPASEPService(final Tribute tribute) {
        super(tribute, 1, 4);
        this.config = new TributesConfig(Tributes.PIS_PASEP);
    }



    public static PISPASEPService createForActualMonth(Tribute cofins) {
        PISPASEPService service = new PISPASEPService(cofins);
        service.period = new DateTime();
        service.construct(service.period);
        return service;
    }

    public static PISPASEPService createForMonth(DateTime period, Tribute cofins) {
        PISPASEPService service = new PISPASEPService(cofins);
        service.period = period;
        service.construct(period);
        return service;
    }

    public static Tribute createPIS(DateTime period, Tribute pis) {
        PISPASEPService service = new PISPASEPService(pis);
        service.period = period;
        service.construct(period);
        pis.setAliq(service.calculateAliq());
        pis.setValue(service.calulate());
        return pis;
    }
}
