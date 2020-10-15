package com.tecsus.ddc;
import org.joda.time.DateTime;

/*
Classe abstrata da conta, são valore que as contas de água e luz possuem iguais
    - Valor; Vencimento; Mês Referência; Número Conta (PK); Período Consumo; Leitura Próxima, Leitura Atual; Leitura Anterior;
 */

public class AbstractClassBill {

    //Atributos
    private double valor;
    private DateTime vencimento;
    private DateTime mesReferencia;
    private String numConta;
    private int periodoConsumo;
    private DateTime leituraProxima;
    private DateTime leituraAtual;
    private DateTime leituraAnterior;

    //Construtor
    public AbstractClassBill (double valor, DateTime vencimento, DateTime mesReferencia, String numConta, int periodoConsumo,
                              DateTime leituraProxima, DateTime leituraAtual, DateTime leituraAnterior) {
        this.valor = valor;
        this.vencimento = vencimento;
        this.mesReferencia = mesReferencia;
        this.numConta = numConta;
        this.periodoConsumo = periodoConsumo;
        this.leituraProxima = leituraProxima;
        this.leituraAtual = leituraAtual;
        this.leituraAnterior = leituraAnterior;

    }
    //Métodos Getters e Setters
    public double getValor(){
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(DateTime vencimento) {
        this.vencimento = vencimento;
    }

    public String getMesReferencia() {
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

    public String getPeriodoConsumo() {
        return periodoConsumo;
    }

    public void setPeriodoConsumo(int periodoConsumo) {
        this.periodoConsumo = periodoConsumo;
    }

    public String getLeituraProxima() {
        return leituraProxima;
    }

    public void setLeituraProxima(DateTime leituraProxima) {
        this.leituraProxima = leituraProxima;
    }

    public String getLeituraAtual() {
        return leituraAtual;
    }

    public void setLeituraAtual(DateTime leituraAtual) {
        this.leituraAtual = leituraAtual;
    }

    public String getLeituraAnterior() {
        return leituraAnterior;
    }

    public void setLeituraAnterior(DateTime leituraAnterior) {
        this.leituraAnterior = leituraAnterior;
    }
}



