package com.tecsus.ddc.bills.energy.builders;

import com.tecsus.ddc.bills.energy.TariffFlag;
import com.tecsus.ddc.bills.energy.enums.TariffFlags;
import org.joda.time.DateTime;

/**
 * @author TOBIASDASILVALINO
 */
public class TariffFlagBuilder {

    private TariffFlags flag;
    private DateTime start;
    private DateTime finish;

    public TariffFlag build() {
        return new TariffFlag(flag, start, finish);
    }

    public TariffFlagBuilder flag(TariffFlags flag) {
        this.flag = flag;
        return this;
    }

    public TariffFlagBuilder start(int day, int month, int year) {
        DateTime start = new DateTime().withDate(year, month, day);
        this.start = start;
        return this;
    }

    public TariffFlagBuilder finish(int day, int month, int year) {
        DateTime finish = new DateTime().withDate(year, month, day);
        this.finish = finish;
        return this;
    }
}
