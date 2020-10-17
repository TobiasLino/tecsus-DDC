package com.tecsus.ddc.controller.service;

import com.tecsus.ddc.bills.Bill;
import com.tecsus.ddc.bills.water.WaterBill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

/**
 * @author TOBIASDASILVALINO
 */
public class WaterBillService implements BillService{

    private static final Logger log = LoggerFactory.getLogger(WaterBillService.class);

    @Override
    public Optional<Object> findById(final String idBill) {
        return Optional.empty();
    }

    @Override
    public <T> List<T> findAll() {
        return null;
    }

    @Override
    public <T> List<T> executeSelect(final String query) {
        return null;
    }

    @Override
    public <T> List<T> responseToList(final ResultSet rs) {
        return null;
    }
}
