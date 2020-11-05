package com.tecsus.ddc.query;

import com.tecsus.ddc.bills.energy.TariffFlag;

import java.text.SimpleDateFormat;

public class TariffFlagQueryFactory implements QueryFactory<TariffFlag> {

    @Override
    public <S extends TariffFlag> String createInsertQuery(S object) {
        return null;
    }

    @Override
    public <S extends TariffFlag> String createInsertQuery(S tariffFlag, String id) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY/MM/dd");
        return "insert into energy_flag_ctrl (id_energy_bill, flag_color, start_date, finish_date)" +
                "values(" +
                "get_id_energy_bill('" + id + "')," +
                "'" + tariffFlag.getFlag().name() + "'," +
                "TO_DATE('" + dateFormat.format(tariffFlag.getStart().toDate()) + "','YYYY/MM/dd')," +
                "TO_DATE('" + dateFormat.format(tariffFlag.getFinish().toDate()) + "','YYYY/MM/dd')" +
                ");";
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
