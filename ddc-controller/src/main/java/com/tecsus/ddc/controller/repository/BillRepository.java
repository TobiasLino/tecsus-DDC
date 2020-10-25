package com.tecsus.ddc.controller.repository;

import com.tecsus.ddc.bills.Bill;

import java.util.Optional;

public interface BillRepository {

    void insert(final Bill bill);
    Optional<Bill> findById(final String idBill);
}
