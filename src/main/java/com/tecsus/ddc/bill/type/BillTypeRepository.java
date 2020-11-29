package com.tecsus.ddc.bill.type;

import com.tecsus.ddc.bill.Bill;
import com.tecsus.ddc.connection.ConnectionImpl;
import com.tecsus.ddc.repository.Repository;
import com.tecsus.ddc.repository.RepositoryStatement;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BillTypeRepository implements RepositoryStatement<Bill>, Repository<Bill> {

    private final ConnectionImpl<Bill> connection;

    public BillTypeRepository(Connection connection) {
        this.connection = new ConnectionImpl<Bill>(connection, this::prepareStatement);
    }

    @Override
    public void saveAll(List<Bill> list) {
        list.forEach(this::save);
    }

    @Override
    public void save(final Bill bill) {
        connection.save(BillTypeQueryFactory.insert(), bill);
    }

    @Override
    public Optional<Bill> find(Object id) {
        return Optional.empty();
    }

    @Override
    public List<Bill> findAll() {
        return null;
    }

    @Override
    public void prepareStatement(PreparedStatement preparedStatement, Bill bill) throws SQLException {
        preparedStatement.setString(1, bill.getBillType().getType());
        preparedStatement.setString(2, bill.getBillNum());
    }
}
