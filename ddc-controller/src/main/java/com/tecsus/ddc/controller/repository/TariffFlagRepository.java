package com.tecsus.ddc.controller.repository;

import com.tecsus.ddc.bills.Bill;
import com.tecsus.ddc.bills.BillFactory;
import com.tecsus.ddc.bills.energy.EnergyBill;
import com.tecsus.ddc.bills.energy.EnergyBillFactory;
import com.tecsus.ddc.bills.energy.TariffFlag;
import com.tecsus.ddc.bills.energy.TariffFlagFactory;
import com.tecsus.ddc.controller.connector.ConnectionImpl;
import com.tecsus.ddc.query.AbstractBillQueryFactory;
import com.tecsus.ddc.query.QueryFactory;
import lombok.AllArgsConstructor;

import javax.ejb.ObjectNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class TariffFlagRepository implements Repository<TariffFlag> {

    private final ConnectionImpl connection;
    private final QueryFactory queryFactory;

    @Override
    public <S extends TariffFlag> void saveAll(Iterable<S> var1) {

    }

    @Override
    public List<TariffFlag> findAll() {
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



    public List<TariffFlag> findAllById(final String id) {
        ResultSet resultSet = null;
        try {
            resultSet = connection
                    .executeSelect(queryFactory.createSelectUniqueQuery(id))
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
    public Optional<TariffFlag> findById(String id) {
        try {
            final ResultSet resultSet = connection
                    .executeSelect(queryFactory.createSelectUniqueQuery(id))
                    .orElseThrow(ObjectNotFoundException::new);
            TariffFlag flag = TariffFlagFactory.constructTariffFlagFromResultSet(resultSet);
            ConnectionImpl.closeResultSet(resultSet);
            return Optional.ofNullable(flag);
        } catch (ObjectNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public <S extends TariffFlag> void save(S var1) {

    }

    @Override
    public <S extends TariffFlag> void update(S var1) {

    }

    private List<TariffFlag> responseToList(ResultSet rs) {
        List<TariffFlag> tariffFlags = new ArrayList<>();
        try {
            tariffFlags.add(TariffFlagFactory.constructTariffFlagFromResultSet(rs));

            while (rs.next()) {
                tariffFlags.add(TariffFlagFactory.constructTariffFlagFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tariffFlags;
    }
}
