package com.tecsus.ddc.controller.repository;

import com.tecsus.ddc.bills.water.WaterBill;
import com.tecsus.ddc.controller.connector.ConnectionImpl;
import com.tecsus.ddc.factory.Factory;
import com.tecsus.ddc.factory.WaterBillFactory;
import com.tecsus.ddc.query.QueryFactory;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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
@Slf4j
public class WaterBillRepository implements Repository<WaterBill> {

    private final ConnectionImpl connection;
    private final QueryFactory<WaterBill> queryFactory;
    private final Factory<WaterBill> waterBillFactory;

    @Override
    public <S extends WaterBill> void saveAll(Iterable<S> var1) {
        var1.forEach(this::save);
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
        Optional<ResultSet> resultSet = connection.executeSelect(queryFactory.createSelectUniqueQuery(id));
        if (resultSet.isPresent()) {
            WaterBill waterBill = waterBillFactory.constructFrom(resultSet.get());
            ConnectionImpl.closeResultSet(resultSet.get());
            return Optional.ofNullable(waterBill);
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
            log.debug("Parsing response to list.");
            while (rs.next()) {
                waterBills.add(waterBillFactory.constructFrom(rs));
            }
        } catch (SQLException e) {
            log.error("Response to list Failed.");
            e.printStackTrace();
        }
        return waterBills;
    }
}
