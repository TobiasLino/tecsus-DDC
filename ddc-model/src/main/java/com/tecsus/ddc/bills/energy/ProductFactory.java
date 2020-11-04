package com.tecsus.ddc.bills.energy;

import com.tecsus.ddc.bills.energy.enums.ProductDescription;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductFactory {

    public static Product constructProductFromResultSet(final ResultSet resultSet) throws SQLException {
        return Product.builder()
                .id(resultSet.getInt("id_product"))
                .kWhQuantity(new BigDecimal(resultSet.getString("kwh_quant")))
                .totalValue(new BigDecimal(resultSet.getString("total_val")))
                .fornecValue(new BigDecimal(resultSet.getString("supply_val")))
                .description(resultSet.getString("prod_desc"))
                .billNum(resultSet.getLong("bill_num"))
                .build();
    }
}
