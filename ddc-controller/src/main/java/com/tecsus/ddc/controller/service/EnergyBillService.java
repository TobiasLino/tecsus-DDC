package com.tecsus.ddc.controller.service;

import com.tecsus.ddc.bills.energy.EnergyBill;
import com.tecsus.ddc.bills.energy.EnergyBillFactory;
import com.tecsus.ddc.bills.water.WaterBill;
import com.tecsus.ddc.bills.water.WaterBillFactory;
import com.tecsus.ddc.controller.connector.ConnectionImpl;
import com.tecsus.ddc.controller.connector.Connector;
import com.tecsus.ddc.controller.repository.EnergyBillRepository;
import com.tecsus.ddc.controller.repository.Repository;
import com.tecsus.ddc.query.EnergyBillQueryFactory;
import com.tecsus.ddc.query.QueryFactory;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.ObjectNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author TOBIASDASILVALINO
 */
@AllArgsConstructor
public class EnergyBillService {

    private final Repository<EnergyBill> energyBillRepository;

    public void insert(final EnergyBill bill) {
        energyBillRepository.save(bill);
    }

    public Optional<EnergyBill> findById(final String idBill) {
        return energyBillRepository.findById(idBill);
    }

    public List<EnergyBill> findAll() {
        return energyBillRepository.findAll();
    }
}
