package com.tecsus.ddc.controller.service;

import com.tecsus.ddc.bills.energy.EnergyBill;
import com.tecsus.ddc.bills.energy.EnergyBillFactory;
import com.tecsus.ddc.bills.water.WaterBill;
import com.tecsus.ddc.bills.water.WaterBillFactory;
import com.tecsus.ddc.controller.connector.ConnectionImpl;
import com.tecsus.ddc.controller.connector.Connector;
import com.tecsus.ddc.controller.repository.EnergyBillRepository;
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
public class EnergyBillService implements EnergyBillRepository {

    private static final Logger log = LoggerFactory.getLogger(EnergyBillService.class);

    private final ConnectionImpl connection;
    private final QueryFactory queryFactory;

    @Override
    public void insert(final EnergyBill bill) {
        connection.executeInsert(queryFactory.createInsertQuery(bill));
    }

    @Override
    public Optional<EnergyBill> findById(final String idBill) {
        ResultSet resultSet = null;
        try {
            resultSet = connection
                    .executeSelect(queryFactory.createSelectUniqueQuery(idBill))
                    .orElseThrow(ObjectNotFoundException::new);
            EnergyBill energyBill = EnergyBillFactory.constructBillFromResultSet(resultSet);
            ConnectionImpl.closeResultSet(resultSet);
            return Optional.ofNullable(energyBill);
        } catch (ObjectNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionImpl.closeResultSet(resultSet);
        }
        return Optional.empty();
    }

    @Override
    public List<EnergyBill> findAll() {
        ResultSet resultSet = null;
        try {
            resultSet = connection
                    .executeSelect(queryFactory.createSelectQuery())
                    .orElseThrow(OutOfMemoryError::new);
            return responseToList(resultSet);
        } catch (OutOfMemoryError outOfMemoryError) {
            outOfMemoryError.printStackTrace();
        } finally {
            ConnectionImpl.closeResultSet(resultSet);
        }
        return Collections.emptyList();
    }

    private List<EnergyBill> responseToList(ResultSet rs) {
        List<EnergyBill> energyBills = new ArrayList<>();
        try {
            while (rs.next()) {
                energyBills.add(EnergyBillFactory.constructBillFromResultSet(rs));
            }
        } catch (SQLException | ObjectNotFoundException e) {
            e.printStackTrace();
        }
        return energyBills;
    }
}
