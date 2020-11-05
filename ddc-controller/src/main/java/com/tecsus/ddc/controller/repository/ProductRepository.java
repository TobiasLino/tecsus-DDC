package com.tecsus.ddc.controller.repository;

import com.tecsus.ddc.bills.energy.Product;
import com.tecsus.ddc.factory.Factory;
import com.tecsus.ddc.factory.ProductFactory;
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

    private final static String ID_PRODUCT = "id_product";

    private final ConnectionImpl connection;
    private final QueryFactory<Product> queryFactory;
    private final Factory<Product> productFactory;


    @Override
    public <S extends Product> void saveAll(Iterable<S> var1) {
        var1.forEach(this::save);
    }

    @Override
    public List<Product> findAll() {
        Optional<ResultSet> resultSet = connection.executeSelect(queryFactory.createSelectQuery());
        return resultSet.map(this::responseToList).orElse(Collections.emptyList());
    }

    public List<Product> findAllById(final String id) {
        Optional<ResultSet> resultSet = connection.executeSelect(queryFactory.createSelectUniqueQuery(id));
        return resultSet.map(this::responseToList).orElse(Collections.emptyList());
    }

    @Override
    public Optional<Product> findById(String id) {
        Optional<ResultSet> resultSet = connection.executeSelect(queryFactory.createSelectUniqueQuery(id, ID_PRODUCT));
        return resultSet.map(productFactory::constructFrom);
    }

    @Override
    public <S extends Product> void save(S var1) {
        connection.executeInsert(queryFactory.createInsertQuery(var1));
    }

    @Override
    public <S extends Product> void update(S var1) {

    }

    private List<Product> responseToList(ResultSet rs) {
        List<Product> products = new ArrayList<>();
        try {
            do {
                products.add(productFactory.constructFrom(rs));
            } while (rs.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
