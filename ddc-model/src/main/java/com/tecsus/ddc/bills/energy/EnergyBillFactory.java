package com.tecsus.ddc.bills.energy;

import org.joda.time.DateTime;

import javax.ejb.ObjectNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnergyBillFactory {

    public static EnergyBill constructBillFromResultSet(final ResultSet rs) throws ObjectNotFoundException, SQLException {
        if (rs == null) {
            throw new ObjectNotFoundException();
        }
        return EnergyBill.builder()
                .consumption(rs.getBigDecimal("consum_kwh"))
                .tension(rs.getInt("tension"))
                .emission(new DateTime(rs.getDate("emission")))
                .build();
    }
}
