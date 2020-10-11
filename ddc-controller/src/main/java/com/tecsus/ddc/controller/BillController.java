package com.tecsus.ddc.controller;

import com.tecsus.ddc.bills.Bill;

import java.util.List;

public interface BillController {

    List<Bill> select(final String whereStatement, final String whereValue);
    void insert(Bill bill);
    void update(long billId, Bill bill);
    void delete(long billId);
}
