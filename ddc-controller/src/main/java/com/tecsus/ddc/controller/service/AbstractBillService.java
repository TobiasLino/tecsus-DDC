package com.tecsus.ddc.controller.service;

import com.tecsus.ddc.bills.Bill;
import com.tecsus.ddc.controller.repository.Repository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class AbstractBillService {

    private final Repository<Bill> billRepository;

    public void insert(final Bill bill) {
        billRepository.save(bill);
    }

    public Optional<Bill> findById(final String id) {
        return billRepository.findById(id);
    }

    public List<Bill> findAll() {
        return billRepository.findAll();
    }
}
