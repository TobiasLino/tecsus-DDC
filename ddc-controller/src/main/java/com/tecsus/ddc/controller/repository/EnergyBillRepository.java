package com.tecsus.ddc.controller.repository;

import com.tecsus.ddc.bills.energy.EnergyBill;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

/**
 * @author TOBIASDASILVALINO
 */
public interface EnergyBillRepository {
    void insert(EnergyBill bill);

    Optional<EnergyBill> findById(String idBill);
    List<EnergyBill> findAll();

    List<EnergyBill> executeSelect(String query);
    List<EnergyBill> responseToList(ResultSet rs);
}
