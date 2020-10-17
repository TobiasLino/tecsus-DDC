package com.tecsus.ddc.bills.builders;

import com.tecsus.ddc.bills.Bill;
import com.tecsus.ddc.instalation.Instalation;
import org.joda.time.DateTime;

import java.math.BigDecimal;

/**
 * @author TOBIASDASILVALINO
 */
public class BillBuilder {

    private Bill bill;

    public BillBuilder() {
        this.bill = new Bill();
    }

    public Bill build() {
        return bill;
    }

    public BillBuilder numMedidor(final String numMedidor) {
        this.bill.setNumMedidor(numMedidor);
        return this;
    }

    public BillBuilder instalation(final Instalation instalation) {
        this.bill.setInstalation(instalation);
        return this;
    }

    public BillBuilder valor(final BigDecimal valor) {
        this.bill.setValor(valor);
        return this;
    }

    public BillBuilder vencimento(final DateTime vencimento) {
        this.bill.setVencimento(vencimento);
        return this;
    }

    public BillBuilder mesReferencia(final DateTime mesReferencia) {
        this.bill.setMesReferencia(mesReferencia);
        return this;
    }

    public BillBuilder numConta(final String numConta) {
        this.bill.setNumConta(numConta);
        return this;
    }

    public BillBuilder periodoConsumo(final int periodoConsumo) {
        this.bill.setPeriodoConsumo(periodoConsumo);
        return this;
    }

    public BillBuilder leituraProxima(final DateTime leituraProxima) {
        this.bill.setLeituraProxima(leituraProxima);
        return this;
    }

    public BillBuilder leituraAtual(final DateTime leituraAtual) {
        this.bill.setLeituraAtual(leituraAtual);
        return this;
    }

    public BillBuilder leituraAnterior(final DateTime leituraAnterior) {
        this.bill.setLeituraAnterior(leituraAnterior);
        return this;
    }

    public BillBuilder valorleituraAnterior(final BigDecimal valor) {
        this.bill.setValorLeituraAnterior(valor);
        return this;
    }

    public BillBuilder valorleituraAtual(final BigDecimal valor) {
        this.bill.setValorLeituraAtual(valor);
        return this;
    }
}
