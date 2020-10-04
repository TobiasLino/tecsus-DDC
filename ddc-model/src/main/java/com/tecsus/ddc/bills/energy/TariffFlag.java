package com.tecsus.ddc.bills.energy;

import com.tecsus.ddc.bills.energy.enums.TariffFlags;
import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TariffFlag {

    private TariffFlags flag;
    private DateTime start;
    private DateTime finish;

    public TariffFlag() {
    }

    public TariffFlag(TariffFlags flag, DateTime start, DateTime finish) {
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

    public void setFlag(TariffFlags flag) {
        this.flag = flag;
    }

    public DateTime getStart() {
        return start;
    }

    public void setStart(DateTime start) {
        this.start = start;
    }

    public DateTime getFinish() {
        return finish;
    }

    public void setFinish(DateTime finish) {
        this.finish = finish;
    }
}
