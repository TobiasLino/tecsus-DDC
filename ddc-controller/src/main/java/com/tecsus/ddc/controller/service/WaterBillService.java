package com.tecsus.ddc.controller.service;

import com.tecsus.ddc.bills.Bill;
import com.tecsus.ddc.bills.water.WaterBill;
import com.tecsus.ddc.controller.BillController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author TOBIASDASILVALINO
 */
public class WaterBillService implements BillController {

    private static final Logger log = LoggerFactory.getLogger(WaterBillService.class);

    public List<Bill> select(String whereStatement, String whereValue) {
        return null;
    }

    public void insert(Bill bill) {
        if (bill == null) {
            throw new NullPointerException();
        }
        if (!(bill instanceof WaterBill)) {
            throw new IllegalArgumentException("Tipo de conta está errado");
        }
        WaterBill wb = (WaterBill)bill;
    }

    public void update(long billId, Bill bill) {

    }

    public void delete(long billId) {

    }
}
