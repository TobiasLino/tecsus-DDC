package com.tecsus.ddc.factory;

import com.tecsus.ddc.bills.energy.Product;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductFactory implements Factory<Product> {

    public Product constructFrom(final ResultSet resultSet) {
        try {
            return Product.builder()
                    .id(resultSet.getInt("id_product"))
                    .kWhQuantity(new BigDecimal(resultSet.getString("kwh_quant")))
                    .totalValue(new BigDecimal(resultSet.getString("total_val")))
                    .fornecValue(new BigDecimal(resultSet.getString("supply_val")))
                    .description(resultSet.getString("prod_desc"))
                    .billNum(resultSet.getString("bill_num"))
                    .build();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
