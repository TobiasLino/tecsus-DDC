package com.tecsus.ddc.bills.energy;


import java.text.SimpleDateFormat;
import java.util.Calendar;

/*
 * Somente para contratos de classe industrial e alta tensão.
 *
 *  @author Tobias Lino
 */
public class RushHour {
    private Calendar start;
    private Calendar finish;

    public RushHour(final Calendar start, final Calendar finish) {
        this.start = start;
        this.finish = finish;
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        return format.format(start.getTime() + " A " + format.format(finish.getTime()));
    }

    public Calendar getStart() {
        return start;
    }

    public void setStart(Calendar start) {
        this.start = start;
    }

    public Calendar getFinish() {
        return finish;
    }

    public void setFinish(Calendar finish) {
        this.finish = finish;
    }
}
