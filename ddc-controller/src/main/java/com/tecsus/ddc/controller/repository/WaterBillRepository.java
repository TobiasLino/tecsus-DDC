package com.tecsus.ddc.controller.repository;

import com.tecsus.ddc.bills.water.WaterBill;
import com.tecsus.ddc.bills.water.WaterBillFactory;
import com.tecsus.ddc.controller.connector.ConnectionImpl;
import com.tecsus.ddc.controller.service.WaterBillService;
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
public class WaterBillRepository implements Repository<WaterBill> {

    private static final Logger log = LoggerFactory.getLogger(WaterBillService.class);

    private final ConnectionImpl connection;
    private final QueryFactory queryFactory;

    @Override
    public <S extends WaterBill> void saveAll(Iterable<S> var1) {

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

    @Override
    public Optional<WaterBill> findById(String id) {
        ResultSet resultSet = null;
        try {
            resultSet = connection
                    .executeSelect(queryFactory.createSelectUniqueQuery(id))
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
    public <S extends WaterBill> void save(S var1) {
        connection.executeInsert(queryFactory.createInsertQuery(var1));
    }

    @Override
    public <S extends WaterBill> void update(S var1) {

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
