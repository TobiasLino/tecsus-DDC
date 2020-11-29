package com.tecsus.ddc.bill;

import java.sql.Connection;

public class BillController {

    private BillRepository billRepository;

    public BillController(Connection connection) {
        billRepository = new BillRepository(connection);
    }

    public void save(Bill bill) {
        billRepository.save(bill);
    }
}
