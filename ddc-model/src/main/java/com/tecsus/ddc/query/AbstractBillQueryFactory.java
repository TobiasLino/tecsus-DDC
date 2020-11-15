package com.tecsus.ddc.utils;

import com.tecsus.ddc.bills.Bill;
import com.tecsus.ddc.query.QueryFactory;

import java.text.SimpleDateFormat;

/**
 * @author TOBIASDASILVALINO
 */
public class AbstractBillQueryFactory implements QueryFactory<Bill> {

    private Bill bill;

    private AbstractBillQueryFactory(final Bill bill) {
        this.bill = bill;
    }

    public AbstractBillQueryFactory() {
    }

    public static String getInsertQuery(final Bill bill) {
        return new AbstractBillQueryFactory(bill).constructInsert();
    }

    public static String getSelectQuery() {
        return new AbstractBillQueryFactory().constructSelect();
    }

    public static String getSelectUniqueQuery(final String billNum) {
        return new AbstractBillQueryFactory().constructUniqueSelect(billNum);
    }

    private String constructInsert() {
        SimpleDateFormat refMonth = new SimpleDateFormat("yyyy/MM");
        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
        return "INSERT INTO bill" +
                "(id_instalation, bill_num, total_value, ref_month, due_date, consum_period, previous_read," +
                "actual_read, next_read, meter_number, previous_read_val, actual_read_val)" +
            "VALUES (" + "'" +
                bill.getInstalation().getNumInst() + "'," + "'" +
                bill.getNumConta() + "'," +
                bill.getValor().toString() + "," +
                "TO_DATE('" + refMonth.format(bill.getMesReferencia().toDate()) + "', 'YYYY/MM')," +
                "TO_DATE('" + date.format(bill.getVencimento().toDate()) + "', 'YYYY/MM/DD')," +
                bill.getPeriodoConsumo() + "," +
                "TO_DATE('" + date.format(bill.getLeituraAnterior().toDate()) + "', 'YYYY/MM/DD')," +
                "TO_DATE('" + date.format(bill.getLeituraAtual().toDate()) + "', 'YYYY/MM/DD')," +
                "TO_DATE('" + date.format(bill.getLeituraProxima().toDate()) + "', 'YYYY/MM/DD'), '" +
                bill.getNumMedidor() + "'," +
                bill.getValorLeituraAnterior().toString() + "," +
                bill.getValorLeituraAtual().toString() +
            ")";
    }

    private String constructSelect() {
        return  "SELECT i.num_inst, cl.*, d.initials, d.site, b.bill_num, b.due_date " +
                "FROM instalation i inner join dealership d on i.id_dealer = d.id_dealership " +
                "INNER JOIN client cl on i.client_cnpj = cl.client_cnpj " +
                "INNER JOIN bill b on b.id_instalation = i.num_inst ";

    }

    private String constructUniqueSelect(final String billNum) {
    }

    @Override
    public <S extends Bill> String createInsertQuery(S object) {
        return null;
    }

    @Override
    public <S extends Bill> String createInsertQuery(S object, String id) {
        return null;
    }

    @Override
    public String createSelectQuery() {
        return null;
    }

    @Override
    public String createSelectUniqueQuery(String billNum) {
        return "select * from bill, instalation, instalation_address, client, dealership " +
                "where bill.bill_num = '" + billNum + "' " +
                "and bill.id_instalation = instalation.num_inst " +
                "and instalation.address = instalation_address.zip " +
                "and instalation.client_cnpj = client.client_cnpj " +
                "and instalation.id_dealer = dealership.id_dealership";
    }

    @Override
    public String createSelectUniqueQuery(String id, String column) {
        return null;
    }
}
