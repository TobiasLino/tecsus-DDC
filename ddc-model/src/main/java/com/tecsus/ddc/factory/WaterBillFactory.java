package com.tecsus.ddc.factory;

import com.tecsus.ddc.bills.water.WaterBill;
import com.tecsus.ddc.factory.BillFactory;
import com.tecsus.ddc.bills.water.enums.BillingType;
import com.tecsus.ddc.bills.water.enums.ConnectionType;

import javax.ejb.ObjectNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WaterBillFactory implements Factory<WaterBill> {

    public WaterBill constructFrom(ResultSet rs) {
        try {
            return WaterBill.builder()
                    .id(rs.getInt("id_water_type"))
                    .conType(ConnectionType.valueOf(rs.getString("con_type")))
                    .billingType(BillingType.valueOf(rs.getString("billing_type")))
                    .consum(rs.getBigDecimal("consum_m3"))
                    .water(rs.getBigDecimal("water_val"))
                    .sewer(rs.getBigDecimal("sewer_val"))
                    .trcf(rs.getBigDecimal("trcf_val"))
                    .tributes(rs.getBigDecimal("tributes"))
                    .build();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
