package com.tecsus.ddc.controller;

import com.tecsus.ddc.bills.water.WaterBill;
import com.tecsus.ddc.controller.service.AbstractBillService;
import com.tecsus.ddc.controller.service.WaterBillService;

/**
 * @author TOBIASDASILVALINO
 */
public class WaterBillController implements Controller {

    private final WaterBillService waterBillService;
    private final AbstractBillService abstractBillService;

    public WaterBillController(
            final WaterBillService waterBillService,
            final AbstractBillService abstractBillService) {
        this.waterBillService = waterBillService;
        this.abstractBillService = abstractBillService;
    }

    @Override
    public void pushBill(Object bill) {
        WaterBill waterBill = (WaterBill) bill;
        abstractBillService.insert(waterBill.getBill());
        waterBillService.insert(waterBill);
    }

    public void deleteBill(final String billNum) {
        // TODO
    }
}
