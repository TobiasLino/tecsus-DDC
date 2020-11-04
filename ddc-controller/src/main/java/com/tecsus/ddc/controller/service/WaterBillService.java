package com.tecsus.ddc.controller.service;

import com.tecsus.ddc.bills.water.WaterBill;
import com.tecsus.ddc.bills.water.WaterBillFactory;
import com.tecsus.ddc.controller.connector.ConnectionImpl;
import com.tecsus.ddc.controller.repository.Repository;
import com.tecsus.ddc.controller.repository.WaterBillRepository;
import com.tecsus.ddc.query.QueryFactory;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.ObjectNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
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
