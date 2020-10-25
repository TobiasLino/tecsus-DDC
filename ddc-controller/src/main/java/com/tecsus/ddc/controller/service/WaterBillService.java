package com.tecsus.ddc.controller.service;

import com.tecsus.ddc.bills.water.WaterBill;
import com.tecsus.ddc.bills.water.WaterBillFactory;
import com.tecsus.ddc.controller.connector.ConnectionImpl;
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
public class WaterBillService implements WaterBillRepository {

    private static final Logger log = LoggerFactory.getLogger(WaterBillService.class);

    private final ConnectionImpl connection;
    private final QueryFactory queryFactory;

    @Override
    public void insert(final WaterBill bill) {
        connection.executeInsert(queryFactory.createInsertQuery(bill));
    }

    @Override
    public Optional<WaterBill> findById(final String idBill) {
        ResultSet resultSet = null;
        try {
            resultSet = connection
                    .executeSelect(queryFactory.createSelectUniqueQuery(idBill))
                    .orElseThrow(ObjectNotFoundException::new);
            WaterBill waterBill = WaterBillFactory.constructBillFromResultSet(resultSet);
            ConnectionImpl.closeResultSet(resultSet);
            return Optional.ofNullable(waterBill);
        } catch (ObjectNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionImpl.closeResultSet(resultSet);
        }
        return Optional.empty();
    }

    @Override
    public List<WaterBill> findAll() {
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

    private List<WaterBill> responseToList(final ResultSet rs) {
        List<WaterBill> waterBills = new ArrayList<>();
        try {
            log.info("Trying to parse response to list..");
            while (rs.next()) {
                waterBills.add(WaterBillFactory.constructBillFromResultSet(rs));
            }
        } catch (SQLException | ObjectNotFoundException e) {
            log.error("Response to list Failed.");
            e.printStackTrace();
        }
        return waterBills;
    }
}
