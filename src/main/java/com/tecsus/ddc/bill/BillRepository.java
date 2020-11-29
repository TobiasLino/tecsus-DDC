package com.tecsus.ddc.bill;

import com.tecsus.ddc.repository.Repository;
import com.tecsus.ddc.bill.type.BillTypeRepository;
import com.tecsus.ddc.connection.ConnectionImpl;
import com.tecsus.ddc.repository.RepositoryStatement;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Slf4j
public class BillRepository implements RepositoryStatement<Bill>, Repository<Bill> {

    private final ConnectionImpl<Bill> connection;
    private final BillTypeRepository billTypeRepository;

    public BillRepository(final Connection connection) {
        this.connection = new ConnectionImpl<Bill>(connection, this::prepareStatement);
        this.billTypeRepository = new BillTypeRepository(connection);
    }

    @Override
    public void saveAll(final List<Bill> bills) {
        bills.forEach(this::save);
    }

    @Override
    public void save(final Bill bill) {
        connection.save(BillQueryFactory.insert(), bill);
        billTypeRepository.save(bill);
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
    public void prepareStatement(final PreparedStatement preparedStatement, final Bill bill) throws SQLException {
        SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd");
        preparedStatement.setString(1, bill.getBillNum());
        preparedStatement.setString(2, bill.getInstalation().getInstalationNumber());
        preparedStatement.setBigDecimal(3, bill.getValue());
        preparedStatement.setDate(4, Date.valueOf(format.format(bill.getRefMonth())));
        preparedStatement.setDate(5, Date.valueOf(format.format(bill.getPreviousRead())));
        preparedStatement.setBigDecimal(6, bill.getPreviousReadValue());
        preparedStatement.setDate(7, Date.valueOf(format.format(bill.getActualRead())));
        preparedStatement.setBigDecimal(8, bill.getActualReadValue());
        preparedStatement.setDate(9, Date.valueOf(format.format(bill.getNextRead())));
        preparedStatement.setDate(10, Date.valueOf(format.format(bill.getDueDate())));
        preparedStatement.setInt(11, bill.getConsum());
        preparedStatement.setInt(12, bill.getConsumPeriod());
        preparedStatement.setString(13, bill.getMeter().getMeterNumber());
    }
}
