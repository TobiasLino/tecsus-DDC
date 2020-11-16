package com.tecsus.ddc.controller.repository;

import com.tecsus.ddc.bills.Bill;
import com.tecsus.ddc.controller.connector.ConnectionImpl;
import com.tecsus.ddc.factory.Factory;
import com.tecsus.ddc.query.QueryFactory;
import lombok.AllArgsConstructor;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
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
        return null;
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
}
