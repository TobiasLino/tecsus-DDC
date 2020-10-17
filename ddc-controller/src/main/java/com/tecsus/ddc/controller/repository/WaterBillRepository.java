package com.tecsus.ddc.controller.repository;

import com.tecsus.ddc.bills.water.WaterBill;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

/**
 * @author TOBIASDASILVALINO
 */
public interface WaterBillRepository {
    void insert(WaterBill bill);

    Optional<WaterBill> findById(String idBill);
    List<WaterBill> findAll();

    List<WaterBill> executeSelect(String query);
    List<WaterBill> responseToList(ResultSet rs);
}
