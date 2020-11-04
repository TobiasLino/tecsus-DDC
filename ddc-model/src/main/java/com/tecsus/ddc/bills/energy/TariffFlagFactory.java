package com.tecsus.ddc.bills.energy;

import com.tecsus.ddc.bills.energy.enums.TariffFlags;
import org.joda.time.DateTime;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TariffFlagFactory {

    public static TariffFlag constructTariffFlagFromResultSet(final ResultSet resultSet) throws SQLException {
        return TariffFlag.builder()
                .flag(TariffFlags.valueOf(resultSet.getString("flag_color")))
                .start(new DateTime(resultSet.getDate("start_date")))
                .finish(new DateTime(resultSet.getDate("finish_date")))
                .build();
    }
}
