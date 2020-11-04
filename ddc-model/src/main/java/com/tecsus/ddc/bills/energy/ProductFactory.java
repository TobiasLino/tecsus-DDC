package com.tecsus.ddc.bills.energy;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductFactory {

    public static Product constructProductFromResultSet(final ResultSet resultSet) throws SQLException {
        return Product.builder()
                .totalValue(new BigDecimal(resultSet.getString("total_val")))
                .id(resultSet.getInt("id_product"))
                .build();
    }
}
