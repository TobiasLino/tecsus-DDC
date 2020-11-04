package com.tecsus.ddc.query;

public class ProductQueryFactory implements QueryFactory {
    @Override
    public String createInsertQuery(Object object) {
        return null;
    }

    @Override
    public String createSelectQuery() {
        return null;
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
