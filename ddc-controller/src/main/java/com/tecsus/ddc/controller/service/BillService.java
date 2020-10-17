package com.tecsus.ddc.controller.service;

import com.tecsus.ddc.bills.Bill;

import java.util.List;

public interface BillService {

    List<Bill> select(final String whereStatement, final String whereValue);
    void insert(Bill bill);
    void update(long billId, Bill bill);
    void delete(long billId);
}
