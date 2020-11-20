package com.tecsus.ddc.query;

import com.tecsus.ddc.bills.energy.Product;

public class ProductQueryFactory implements QueryFactory<Product> {

    @Override
    public <S extends Product> String createInsertQuery(S product) {
        return "INSERT INTO energy_product (kwh_quant, total_val, supply_val, prod_desc, bill_num) " +
                "VALUES (" +
                (product.getKWhQuantity() != null ? product.getKWhQuantity().toString() + ", " : "") +
                (product.getTotalValue() != null ? product.getTotalValue().toString() + ", " : "") +
                (product.getFornecValue() != null ? product.getFornecValue().toString() + ", " : "") +
                (product.getDescription() != null ? "'" + product.getDescription() + "', " : "") +
                (product.getBillNum() != null ? "'" + product.getBillNum() + "'" : "") +
                ")";
    }

    @Override
    public <S extends Product> String createInsertQuery(S object, String id) {
        return null;
    }

    @Override
    public String createSelectQuery() {
        return "SELECT * FROM energy_product";
    }

    public String createSelectUniqueQuery(final String id, final String column) {
        return "SELECT * FROM energy_product WHERE energy_product."+ column + " = " + id;
    }

    @Override
    public String createSelectUniqueQuery(String id) {
        return "SELECT eb.id_energy_type, ep.kwh_quant, ep.total_val, ep.supply_val, ep.prod_desc, ept.cci, ep.id_product " +
                "FROM energy_bill eb inner join energy_product ep ON " +
                "eb.id_energy_type = ep.bill_num INNER JOIN energy_product_type ept on " +
                "ep.prod_desc = ept.descript "+
                "WHERE eb.id_energy_type = " + id;
    }
}
