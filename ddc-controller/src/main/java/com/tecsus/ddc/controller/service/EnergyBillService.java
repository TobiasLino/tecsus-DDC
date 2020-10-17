package com.tecsus.ddc.controller.service;

import com.tecsus.ddc.bills.Bill;
import com.tecsus.ddc.bills.energy.EnergyBill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author TOBIASDASILVALINO
 */
public class EnergyBillService implements BillService {

    private static final Logger log = LoggerFactory.getLogger(EnergyBillService.class);

    public List<Bill> select(String whereStatement, String whereValue) {
        return null;
    }

    public void insert(Bill bill) {
        if (bill == null) {
            throw new NullPointerException();
        }
        if (!(bill instanceof EnergyBill)) {
            throw new IllegalArgumentException("Tipo de conta está errado");
        }
        EnergyBill wb = (EnergyBill)bill;

    }

    public void update(long billId, Bill bill) {

    }

    public void delete(long billId) {

    }
}
