package com.tecsus.ddc.controller.service;

import com.tecsus.ddc.bills.Bill;
import com.tecsus.ddc.bills.energy.EnergyBill;
import com.tecsus.ddc.bills.energy.Product;
import com.tecsus.ddc.bills.energy.TariffFlag;
import com.tecsus.ddc.controller.repository.Repository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

/**
 * @author TOBIASDASILVALINO
 */
@AllArgsConstructor
public class EnergyBillService {

    private final Repository<EnergyBill> energyBillRepository;
    private final Repository<Product> productRepository;
    private final Repository<TariffFlag> tariffFlagRepository;
    private final Repository<Bill> billRepository;

    public void insert(final EnergyBill bill) {
        energyBillRepository.save(bill);
        billRepository.save(bill.getBill());
        bill.getProducts().forEach(productRepository::save);
        bill.getTariffFlags().forEach(tariffFlagRepository::save);
    }

    public Optional<EnergyBill> findById(final String idBill) {
        return energyBillRepository.findById(idBill);
    }

    public List<EnergyBill> findAll() {
        return energyBillRepository.findAll();
    }
}
