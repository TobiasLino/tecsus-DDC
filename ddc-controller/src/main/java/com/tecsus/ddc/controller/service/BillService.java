package com.tecsus.ddc.controller.service;

import com.tecsus.ddc.bills.Bill;
import com.tecsus.ddc.controller.BillController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author TOBIASDASILVALINO
 */
public class BillService implements BillController {

    private static final Logger log = LoggerFactory.getLogger(BillService.class);

    public List<Bill> select(String whereStatement, String whereValue) {
        return null;
    }

    public void insert(Bill bill) {

    }

    public void update(long billId, Bill bill) {

    }

    public void delete(long billId) {

    }
}
