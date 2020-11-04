package com.tecsus.ddc.controller.repository;

import com.tecsus.ddc.bills.energy.Product;
import com.tecsus.ddc.bills.energy.ProductFactory;
import com.tecsus.ddc.bills.energy.TariffFlag;
import com.tecsus.ddc.bills.energy.TariffFlagFactory;
import com.tecsus.ddc.controller.connector.ConnectionImpl;
import com.tecsus.ddc.query.QueryFactory;
import lombok.AllArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class ProductRepository implements Repository<Product> {


    private final ConnectionImpl connection;
    private final QueryFactory queryFactory;


    @Override
    public <S extends Product> void saveAll(Iterable<S> var1) {

    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    public List<Product> findAllById(final String id) {
        Optional<ResultSet> resultSet = null;
        try {
            resultSet = connection.executeSelect(queryFactory.createSelectUniqueQuery(id));

            if (resultSet.isPresent()) {
                return responseToList(resultSet.get());
            }
        } catch (OutOfMemoryError outOfMemoryError) {
            outOfMemoryError.printStackTrace();
        } finally {
            ConnectionImpl.closeResultSet(resultSet.get());
        }
        return Collections.emptyList();
    }

    @Override
    public Optional<Product> findById(String id) {
        return Optional.empty();
    }

    @Override
    public <S extends Product> void save(S var1) {

    }

    @Override
    public <S extends Product> void update(S var1) {

    }

    private List<Product> responseToList(ResultSet rs) {
        List<Product> products = new ArrayList<>();
        try {
            products.add(ProductFactory.constructProductFromResultSet(rs));

            while (rs.next()) {
                products.add(ProductFactory.constructProductFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
