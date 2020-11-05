package com.tecsus.ddc.factory;

import com.tecsus.ddc.bills.energy.EnergyBill;
import org.joda.time.DateTime;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EnergyBillFactory implements Factory<EnergyBill> {

    public EnergyBill constructFrom(final ResultSet rs) {
        try {
            return EnergyBill.builder()
                    .id(rs.getInt("id_energy_type"))
                    .consumption(rs.getBigDecimal("consum_kwh"))
                    .tension(rs.getInt("tension"))
                    .emission(new DateTime(rs.getDate("emission")))
                    .build();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
