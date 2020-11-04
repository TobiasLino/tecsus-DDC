package com.tecsus.ddc.query;

public class TariffFlagQueryFactory implements QueryFactory {
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
        return "SELECT eb.abs_bill, efc.flag_color, efc.start_date, efc.finish_date " +
                "FROM energy_bill eb INNER JOIN energy_flag_ctrl efc " +
                "ON eb.id_energy_type = efc.id_energy_bill " +
                "WHERE eb.id_energy_type = " + id;
    }

    @Override
    public String createSelectUniqueQuery(String id, String column) {
        return null;
    }
}
