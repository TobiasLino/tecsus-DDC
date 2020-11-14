package com.tecsus.ddc.controller;

import com.tecsus.ddc.bills.energy.EnergyBill;
import com.tecsus.ddc.controller.connector.Connector;
import com.tecsus.ddc.controller.service.AbstractBillService;
import com.tecsus.ddc.controller.service.EnergyBillService;

public class EnergyBillController {

    private EnergyBillService waterBillService;
    private AbstractBillService abstractBillService;

    public EnergyBillController() {
        Connector connector = new Connector();
        energyBillService = new EnergyBillService(connector);
        abstractBillService = new AbstractBillService(connector);
    }

    public void pushBill(EnergyBill bill) {
        abstractBillService.insert(bill.getBill());
        energyBillService.insert(bill);
    }

}
