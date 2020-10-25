package com.tecsus.ddc.controller.service;

import com.tecsus.ddc.bills.Bill;
import com.tecsus.ddc.bills.BillFactory;
import com.tecsus.ddc.bills.water.WaterBill;
import com.tecsus.ddc.bills.water.WaterBillFactory;
import com.tecsus.ddc.controller.connector.ConnectionImpl;
import com.tecsus.ddc.controller.connector.Connector;
import com.tecsus.ddc.controller.repository.BillRepository;
import com.tecsus.ddc.query.AbstractBillQueryFactory;
import com.tecsus.ddc.query.QueryFactory;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.ObjectNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

@AllArgsConstructor
public class AbstractBillService implements BillRepository {

    private final ConnectionImpl connection;
    private final QueryFactory queryFactory;

    @Override
    public void insert(final Bill bill) {
        connection.executeInsert(queryFactory.createInsertQuery(bill));
    }

    @Override
    public Optional<Bill> findById(final String idBill) {
        try {
            final ResultSet resultSet = connection
                    .executeSelect(queryFactory.createSelectUniqueQuery(idBill))
                    .orElseThrow(ObjectNotFoundException::new);
            Bill waterBill = BillFactory.constructBillFromResultSet(resultSet);
            ConnectionImpl.closeResultSet(resultSet);
            return Optional.ofNullable(waterBill);
        } catch (ObjectNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
