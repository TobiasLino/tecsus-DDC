package com.tecsus.ddc.utils.query;

import com.tecsus.ddc.bills.Bill;

/**
 * @author TOBIASDASILVALINO
 */
public class BillQuery implements QueryConstructor {

    private String query;

    public BillQuery() {
        this.query = "";
    }

    @Override
    public QueryConstructor insert() {
        query += "INSERT INTO ";
        return this;
    }

    @Override
    public QueryConstructor table(final String table) {
        query += table;
        return this;
    }

    public QueryConstructor values(Bill bill) {
        query += fields();
        return this;
    }

    private String fields () {
        return " ("
                + "bill_num, "
                + "id_instalation, "
                + "total_value, "
                + "ref_month, "
                + "due_date, "
                + "consum_period, "
                + "previous_read, "
                + "actual_read, "
                + "next_read, "
                + "meter_number, "
                + "previous_read_val, "
                + "actual_read_val" + ") ";
    }

    @Override
    public String build() {
        return null;
    }
}
