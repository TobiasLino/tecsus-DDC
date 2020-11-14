package com.tecsus.ddc.controller.repository;

import com.tecsus.ddc.bills.Bill;
import com.tecsus.ddc.bills.energy.EnergyBill;
import com.tecsus.ddc.controller.connector.ConnectionImpl;
import com.tecsus.ddc.factory.Factory;
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
public class EnergyBillRepository implements Repository<EnergyBill> {

    private final ConnectionImpl connection;
    private final QueryFactory<EnergyBill> queryFactory;

    private final Factory<EnergyBill> energyBillFactory;
    private final Factory<Bill> abstractBillFactory;


    @Override
    public <S extends EnergyBill> void saveAll(Iterable<S> var1) {
        var1.forEach(this::save);
    }

    @Override
    public List<EnergyBill> findAll() {
        Optional<ResultSet> resultSet = connection.executeSelect(queryFactory.createSelectQuery());
        log.debug(resultSet.toString());
        return resultSet.map(this::responseToList).orElse(Collections.emptyList());
    }

    @Override
    public Optional<EnergyBill> findById(String id) {
        Optional<ResultSet> resultSet = connection.executeSelect(queryFactory.createSelectUniqueQuery(id));
        if (resultSet.isPresent()) {
            EnergyBill energyBill = energyBillFactory.constructFrom(resultSet.get());
            return Optional.ofNullable(energyBill);
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


    private List<EnergyBill> responseToList(ResultSet resultSet) {
        List<EnergyBill> energyBills = new ArrayList<>();
        try {
            do {
                EnergyBill energyBill = energyBillFactory.constructFrom(resultSet);
                energyBill.setBill(abstractBillFactory.constructFrom(resultSet));

                energyBills.add(energyBill);
            } while (resultSet.next());

            log.debug(energyBills.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return energyBills;
    }
}
