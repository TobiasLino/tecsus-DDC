package com.tecsus.ddc.controller.repository;

import com.tecsus.ddc.bills.Bill;
import com.tecsus.ddc.factory.BillFactory;
import com.tecsus.ddc.controller.connector.ConnectionImpl;
import com.tecsus.ddc.factory.Factory;
import com.tecsus.ddc.instalation.Instalation;
import com.tecsus.ddc.query.AbstractBillQueryFactory;
import lombok.AllArgsConstructor;

import javax.ejb.ObjectNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
public class BillRepository implements Repository<Bill> {

    private final ConnectionImpl connection;
    private final AbstractBillQueryFactory queryFactory;
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
        try {
            final ResultSet resultSet = connection
                    .executeSelect(queryFactory.createSelectUniqueQuery(id))
                    .orElseThrow(ObjectNotFoundException::new);
            Bill bill = billFactory.constructFrom(resultSet);

            ConnectionImpl.closeResultSet(resultSet);

            return Optional.of(bill);
        } catch (ObjectNotFoundException e) {
            e.printStackTrace();
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
