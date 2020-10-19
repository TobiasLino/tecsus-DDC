package com.tecsus.ddc.controller;

import com.tecsus.ddc.bills.water.WaterBill;
import com.tecsus.ddc.controller.connector.Connector;
import com.tecsus.ddc.controller.service.AbstractBillService;
import com.tecsus.ddc.controller.service.WaterBillService;

/**
 * @author TOBIASDASILVALINO
 */
public class WaterBillController {

    private WaterBillService waterBillService;
    private AbstractBillService abstractBillService;

    public WaterBillController() {
        Connector connector = new Connector();
        waterBillService = new WaterBillService(connector);
        abstractBillService = new AbstractBillService(connector);
    }

    public void pushBill(WaterBill bill) {
        abstractBillService.insert(bill.getBill());
        waterBillService.insert(bill);
    }
}
