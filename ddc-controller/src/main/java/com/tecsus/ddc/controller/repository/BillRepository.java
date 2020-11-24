package com.tecsus.ddc.controller.repository;

import com.tecsus.ddc.bills.Bill;
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

@AllArgsConstructor
@Slf4j
public class BillRepository implements Repository<Bill> {

    private final ConnectionImpl connection;
    private final QueryFactory<Bill> queryFactory;
    private final Factory<Bill> billFactory;

    @Override
    public <S extends Bill> void saveAll(Iterable<S> var1) {
        var1.forEach(this::save);
    }


    @Override
    public List<Bill> findAll() {
        Optional<ResultSet> resultSet = connection.executeSelect(queryFactory.createSelectQuery());
        log.debug(resultSet.toString());
        return resultSet.map(this::responseToList).orElse(Collections.emptyList());
    }

    @Override
    public Optional<Bill> findById(final String id) {
        final Optional<ResultSet> resultSet = connection.executeSelect(queryFactory.createSelectUniqueQuery(id));
        if (resultSet.isPresent()) {
            Bill bill = billFactory.constructFrom(resultSet.get());
            ConnectionImpl.closeResultSet(resultSet.get());
            return Optional.of(bill);
        }
        return Optional.empty();
    }

    @Override
    public <S extends Bill> void save(S var1){
        connection.executeInsert(queryFactory.createInsertQuery(var1));
    }

    @Override
    public <S extends Bill> void update(S var1) {

    }


    private List<Bill> responseToList(final ResultSet resultSet) {
        List<Bill> bills = new ArrayList<>();
        try {
            do {
                Bill bill = billFactory.constructFrom(resultSet);

                bills.add(bill);
            } while (resultSet.next());

            log.debug(bills.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bills;
    }
}
