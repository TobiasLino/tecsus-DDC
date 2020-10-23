package com.tecsus.ddc.bills;
import com.tecsus.ddc.instalation.Instalation;
import org.joda.time.DateTime;

import java.math.BigDecimal;

/*
Classe abstrata da conta, são valore que as contas de água e luz possuem iguais
    - Valor; Vencimento; Mês Referência; Número Conta (PK); Período Consumo; Leitura Próxima, Leitura Atual; Leitura Anterior;
 */

public class Bill {

    //Atributos
    private Instalation instalation;
    private BigDecimal valor;
    private DateTime vencimento;
    private DateTime mesReferencia;
    private String numConta;
    private int periodoConsumo;
    private DateTime leituraProxima;
    private DateTime leituraAtual;
    private DateTime leituraAnterior;
    private String numMedidor;
    private BigDecimal valorLeituraAnterior;
    private BigDecimal valorLeituraAtual;

    public Bill() {
    }

    @Override
    public String toString() {
        return "AbstractClassBill{" +
                "instalation='" + instalation + '\'' +
                ", valor=" + valor +
                ", vencimento=" + vencimento +
                ", mesReferencia=" + mesReferencia +
                ", numConta='" + numConta + '\'' +
                ", periodoConsumo=" + periodoConsumo +
                ", leituraProxima=" + leituraProxima +
                ", leituraAtual=" + leituraAtual +
                ", leituraAnterior=" + leituraAnterior +
                '}';
    }

    //Métodos Getters e Setters
    public BigDecimal getValor(){
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public DateTime getVencimento() {
        return vencimento;
    }

    public void setVencimento(DateTime vencimento) {
        this.vencimento = vencimento;
    }

    public DateTime getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(DateTime mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    public String getNumConta() {
        return numConta;
    }

    public void setNumConta(String numConta) {
        this.numConta = numConta;
    }

    public int getPeriodoConsumo() {
        return periodoConsumo;
    }

    public void setPeriodoConsumo(int periodoConsumo) {
        this.periodoConsumo = periodoConsumo;
    }

    public DateTime getLeituraProxima() {
        return leituraProxima;
    }

    public void setLeituraProxima(DateTime leituraProxima) {
        this.leituraProxima = leituraProxima;
    }

    public DateTime getLeituraAtual() {
        return leituraAtual;
    }

    public void setLeituraAtual(DateTime leituraAtual) {
        this.leituraAtual = leituraAtual;
    }

    public DateTime getLeituraAnterior() {
        return leituraAnterior;
    }

    public void setLeituraAnterior(DateTime leituraAnterior) {
        this.leituraAnterior = leituraAnterior;
    }

    public Instalation getInstalation() {
        return instalation;
    }

    public void setInstalation(final Instalation instalation) {
        this.instalation = instalation;
    }

    public String getNumMedidor() {
        return numMedidor;
    }

    public void setNumMedidor(final String numMedidor) {
        this.numMedidor = numMedidor;
    }

    public BigDecimal getValorLeituraAnterior() {
        return valorLeituraAnterior;
    }

    public void setValorLeituraAnterior(final BigDecimal valorLeituraAnterior) {
        this.valorLeituraAnterior = valorLeituraAnterior;
    }

    public BigDecimal getValorLeituraAtual() {
        return valorLeituraAtual;
    }

    public void setValorLeituraAtual(final BigDecimal valorLeituraAtual) {
        this.valorLeituraAtual = valorLeituraAtual;
    }
}
