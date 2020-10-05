package com.tecsus.ddc.bills.energy;

import com.tecsus.ddc.bills.energy.enums.TariffFlags;
import org.joda.time.DateTime;

import java.text.SimpleDateFormat;

/**
 * @author TOBIASDASILVALINO
 */
public class TariffFlag {

    private TariffFlags flag;
    private DateTime start;
    private DateTime finish;

    public TariffFlag() {
    }

    public TariffFlag(
            final TariffFlags flag,
            final DateTime start,
            final DateTime finish) {
        this.flag = flag;
        this.start = start;
        this.finish = finish;
    }

    @Override
    public String toString() {
        SimpleDateFormat form = new SimpleDateFormat("dd/MM/YYYY");
        return "TariffFlag{" +
                "flag=" + flag.toString() +
                ", start=" + form.format(start.toDate()) +
                ", finish=" + form.format(finish.toDate()) +
                '}';
    }

    public TariffFlags getFlag() {
        return flag;
    }

    public void setFlag(final TariffFlags flag) {
        this.flag = flag;
    }

    public DateTime getStart() {
        return start;
    }

    public void setStart(final DateTime start) {
        this.start = start;
    }

    public DateTime getFinish() {
        return finish;
    }

    public void setFinish(final DateTime finish) {
        this.finish = finish;
    }
}
