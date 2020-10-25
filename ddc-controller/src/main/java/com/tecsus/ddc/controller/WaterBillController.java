package com.tecsus.ddc.controller;

import com.tecsus.ddc.bills.water.WaterBill;
import com.tecsus.ddc.controller.service.AbstractBillService;
import com.tecsus.ddc.controller.service.WaterBillService;

/**
 * @author TOBIASDASILVALINO
 */
public class WaterBillController {

    private final WaterBillService waterBillService;
    private final AbstractBillService abstractBillService;

    public WaterBillController(
            final WaterBillService waterBillService,
            final AbstractBillService abstractBillService) {
        this.waterBillService = waterBillService;
        this.abstractBillService = abstractBillService;
    }

    public void pushBill(WaterBill bill) {
        abstractBillService.insert(bill.getBill());
        waterBillService.insert(bill);
    }

    public void deleteBill(final String billNum) {
        // TODO
    }
}
