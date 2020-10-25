package com.tecsus.ddc.bills.energy;

import com.tecsus.ddc.bills.energy.builders.EnergyBillBuilder;
import org.joda.time.DateTime;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EnergyBillFactory {

    public static EnergyBill constructEnergyBillFromResultSet(final ResultSet rs) throws SQLException {
        return EnergyBillBuilder.anEnergyBill()
                .consumption(rs.getBigDecimal("consum_kwh"))
                .tension(rs.getInt("tension"))
                .emission(new DateTime(rs.getDate("emission")))
                .build();
    }
}
