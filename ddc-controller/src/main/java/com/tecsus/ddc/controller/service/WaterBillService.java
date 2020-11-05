package com.tecsus.ddc.controller.service;

import com.tecsus.ddc.bills.water.WaterBill;
import com.tecsus.ddc.controller.repository.Repository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

/**
 * @author TOBIASDASILVALINO
 */
@AllArgsConstructor
public class WaterBillService {

    private final Repository<WaterBill> waterBillRepository;

    public Optional<WaterBill> findById(final String id) {
        return waterBillRepository.findById(id);
    }

    public List<WaterBill> findAll() {
        return waterBillRepository.findAll();
    }

    public void insert(final WaterBill bill) {
        waterBillRepository.save(bill);
    }

    public void insertAll(final Iterable<WaterBill> bills) {
        waterBillRepository.saveAll(bills);
    }
}
