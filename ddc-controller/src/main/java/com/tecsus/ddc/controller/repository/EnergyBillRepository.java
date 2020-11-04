package com.tecsus.ddc.controller.repository;

import com.tecsus.ddc.bills.energy.EnergyBill;
import com.tecsus.ddc.bills.energy.EnergyBillFactory;
import com.tecsus.ddc.controller.connector.ConnectionImpl;
import com.tecsus.ddc.query.QueryFactory;
import lombok.AllArgsConstructor;

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
public class EnergyBillRepository implements Repository<EnergyBill> {

    private final ConnectionImpl connection;
    private final QueryFactory queryFactory;


    @Override
    public <S extends EnergyBill> void saveAll(Iterable<S> var1) {
        var1.forEach(this::save);
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

    @Override
    public Optional<EnergyBill> findById(String id) {
        ResultSet resultSet = null;
        try {
            resultSet = connection
                    .executeSelect(queryFactory.createSelectUniqueQuery(id))
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
    public <S extends EnergyBill> void save(S var1) {
        connection.executeInsert(queryFactory.createInsertQuery(var1));
    }

    @Override
    public <S extends EnergyBill> void update(S var1) {

    }


    private List<EnergyBill> responseToList(ResultSet rs) {
        List<EnergyBill> energyBills = new ArrayList<>();
        try {
            do {
                energyBills.add(EnergyBillFactory.constructBillFromResultSet(rs));
            } while (rs.next());
        } catch (SQLException | ObjectNotFoundException e) {
            e.printStackTrace();
        }
        return energyBills;
    }
}
