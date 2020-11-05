package com.tecsus.ddc.factory;

import com.tecsus.ddc.bills.energy.TariffFlag;
import com.tecsus.ddc.bills.energy.enums.TariffFlags;
import org.joda.time.DateTime;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TariffFlagFactory implements Factory<TariffFlag> {

    public TariffFlag constructFrom(final ResultSet resultSet) {
        try {
            return TariffFlag.builder()
                    .flag(TariffFlags.valueOf(resultSet.getString("flag_color")))
                    .start(new DateTime(resultSet.getDate("start_date")))
                    .finish(new DateTime(resultSet.getDate("finish_date")))
                    .build();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
