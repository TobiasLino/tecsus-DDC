package com.tecsus.ddc.query;

import com.tecsus.ddc.bills.Bill;

import java.text.SimpleDateFormat;
import java.util.Optional;

/**
 * @author TOBIASDASILVALINO
 */
public class AbstractBillQueryFactory implements QueryFactory {

    private Bill bill;

    private AbstractBillQueryFactory(final Bill bill) {
        this.bill = bill;
    }

    public AbstractBillQueryFactory() {
    }

    @Override
    public String createInsertQuery(final Object object) {
        return new AbstractBillQueryFactory((Bill) object).constructInsert();
    }

    @Override
    public String createSelectQuery() {
        return new AbstractBillQueryFactory().constructSelect();
    }

    public String createSelectUniqueQuery(final String id) {
        return new AbstractBillQueryFactory().constructUniqueSelect(id);
    }

    @Override
    public String createSelectUniqueQuery(String id, String column) {
        return null;
    }

    private String constructInsert() {
        SimpleDateFormat refMonth = new SimpleDateFormat("yyyy/MM");
        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
        // TODO verificar os nulos
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
        return "SELECT * FROM bill, instalation, instalation_address, client, dealership" +
                "WHERE bill.id_instalation = instalation.num_inst " +
                "AND instalation.address = instalation_address.zip " +
                "AND instalation.client_cnpj = client.client_cnpj " +
                "AND instalation.id_dealer = dealership.id_dealership";
    }

    private String constructUniqueSelect(final String billNum) {
        return "SELECT * FROM bill, instalation, instalation_address, client, dealership " +
                "WHERE bill.bill_num = '" + billNum + "' " +
                "AND bill.id_instalation = instalation.num_inst " +
                "AND instalation.address = instalation_address.zip " +
                "AND instalation.client_cnpj = client.client_cnpj " +
                "AND instalation.id_dealer = dealership.id_dealership";
    }
}
