// @author Ruan
package com.tecsus.ddc.view.frames.energy;

import com.tecsus.ddc.bills.energy.EnergyBill;
import com.tecsus.ddc.controller.EnergyBillController;
import com.tecsus.ddc.controller.service.EnergyBillService;
import com.tecsus.ddc.view.frames.generator.EnergyBillGenerator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Energia extends javax.swing.JInternalFrame {

    private EnergyBill controller;
    private EnergiaBillFormTextFields fields;

    public Energia() {
        fields = new EnergiaBillFormTextFields();
        controller = new EnergyBill();
        initComponents();
    }

    private void initComponents() {

        txtEndereco = new javax.swing.JLabel();
        txtNumEnd = new javax.swing.JLabel();
        txtComplementoEnd = new javax.swing.JLabel();
        txtCep = new javax.swing.JLabel();
        txtCidade = new javax.swing.JLabel();
        txtBairro = new javax.swing.JLabel();
        txtCnpj = new javax.swing.JLabel();
        txtRazao = new javax.swing.JLabel();
        txtInsEstadual = new javax.swing.JLabel();
        txtCliente = new javax.swing.JLabel();
        txtCodIdent = new javax.swing.JLabel();
        txtCodFisOp = new javax.swing.JLabel();
        txtGrupoSubGrupo = new javax.swing.JLabel();
        txtClaSubCla = new javax.swing.JLabel();
        txtTipoFornecimento = new javax.swing.JLabel();
        txtModTarifa = new javax.swing.JLabel();
        txtRotLeitura = new javax.swing.JLabel();
        txtTensNominal = new javax.swing.JLabel();
        txtNmedidor = new javax.swing.JLabel();
        txtNumInstal = new javax.swing.JLabel();
        txtInicio = new javax.swing.JLabel();
        txtFim = new javax.swing.JLabel();
        txtTipoBandeira = new javax.swing.JLabel();
        txtDiasBandeira = new javax.swing.JLabel();
        txtContMes = new javax.swing.JLabel();
        txtVenc = new javax.swing.JLabel();
        txtConsumo = new javax.swing.JLabel();
        txtValorTotalPagar = new javax.swing.JLabel();
        txtDtLeitAnterior = new javax.swing.JLabel();
        txtDtLeitAtual = new javax.swing.JLabel();
        txtAnteriorHwh = new javax.swing.JLabel();
        txtEmissao = new javax.swing.JLabel();
        txtDiasFaturamento = new javax.swing.JLabel();
        txtDtProxLeitura = new javax.swing.JLabel();
        txtAtualKwh = new javax.swing.JLabel();
        txtTarifaAplicTusd = new javax.swing.JLabel();
        txtValorFornTusd = new javax.swing.JLabel();
        txtTarifaImpostoTusd = new javax.swing.JLabel();
        txtBCalcICMSTusd = new javax.swing.JLabel();
        txtValorIcmsTusd = new javax.swing.JLabel();
        txtBCalcPisCofTusd = new javax.swing.JLabel();
        txtAliqPisTusd = new javax.swing.JLabel();
        txtValorPisTusd = new javax.swing.JLabel();
        txtAliqConfTusd = new javax.swing.JLabel();
        txtValorConfTusd = new javax.swing.JLabel();
        txtValorTotalTusd = new javax.swing.JLabel();
        txtTarAplicTE = new javax.swing.JLabel();
        txtValorFornTE = new javax.swing.JLabel();
        txtTarImpostoTE = new javax.swing.JLabel();
        txtBaseCalIcmsTE = new javax.swing.JLabel();
        txtValorIcmsTE = new javax.swing.JLabel();
        txtBCalcPisCofTE = new javax.swing.JLabel();
        txtAliqPisTE = new javax.swing.JLabel();
        txtValorPisTE = new javax.swing.JLabel();
        txtAliqCofTE = new javax.swing.JLabel();
        txtValorCofTE = new javax.swing.JLabel();
        txtValorTotalTE = new javax.swing.JLabel();
        txtCIP = new javax.swing.JLabel();
        txtJurosMora = new javax.swing.JLabel();
        txtOutroValores = new javax.swing.JLabel();
        txtValorFornVT = new javax.swing.JLabel();
        txtBCalIcmsVT = new javax.swing.JLabel();
        txtValorIcmsVT = new javax.swing.JLabel();
        txtBCalcPisCofVT = new javax.swing.JLabel();
        txtValorPisVT = new javax.swing.JLabel();
        txtValorCofVT = new javax.swing.JLabel();
        txtPisTributo = new javax.swing.JLabel();
        txtCofTributo = new javax.swing.JLabel();
        txtIcmsTributo = new javax.swing.JLabel();
        txCodBarras = new javax.swing.JLabel();

    }

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }

    private void btnSalvarActionPerformed(ActionEvent evt) { controller.pus hBill(EnergyBillGenerator.generate(fields));
    }

    //declaration of variables
    private javax.swing.JLabel txtEndereco;
    private javax.swing.JLabel txtNumEnd;
    private javax.swing.JLabel txtComplementoEnd;
    private javax.swing.JLabel txtCep;
    private javax.swing.JLabel txtCidade;
    private javax.swing.JLabel txtBairro;
    private javax.swing.JLabel txtCnpj;
    private javax.swing.JLabel txtRazao;
    private javax.swing.JLabel txtInsEstadual;
    private javax.swing.JLabel txtCliente;
    private javax.swing.JLabel txtCodIdent;
    private javax.swing.JLabel txtCodFisOp;
    private javax.swing.JLabel txtGrupoSubGrupo;
    private javax.swing.JLabel txtClaSubCla;
    private javax.swing.JLabel txtTipoFornecimento;
    private javax.swing.JLabel txtModTarifa;
    private javax.swing.JLabel txtRotLeitura;
    private javax.swing.JLabel txtTensNominal;
    private javax.swing.JLabel txtNmedidor;
    private javax.swing.JLabel txtNumInstal;
    private javax.swing.JLabel txtInicio;
    private javax.swing.JLabel txtFim;
    private javax.swing.JLabel txtTipoBandeira;
    private javax.swing.JLabel txtDiasBandeira;
    private javax.swing.JLabel txtContMes;
    private javax.swing.JLabel txtVenc;
    private javax.swing.JLabel txtConsumo;
    private javax.swing.JLabel txtValorTotalPagar;
    private javax.swing.JLabel txtDtLeitAnterior;
    private javax.swing.JLabel txtDtLeitAtual;
    private javax.swing.JLabel txtAnteriorHwh;
    private javax.swing.JLabel txtEmissao;
    private javax.swing.JLabel txtDiasFaturamento;
    private javax.swing.JLabel txtDtProxLeitura;
    private javax.swing.JLabel txtAtualKwh;
    private javax.swing.JLabel txtTarifaAplicTusd;
    private javax.swing.JLabel txtValorFornTusd;
    private javax.swing.JLabel txtTarifaImpostoTusd;
    private javax.swing.JLabel txtBCalcICMSTusd;
    private javax.swing.JLabel txtValorIcmsTusd;
    private javax.swing.JLabel txtBCalcPisCofTusd;
    private javax.swing.JLabel txtAliqPisTusd;
    private javax.swing.JLabel txtValorPisTusd;
    private javax.swing.JLabel txtAliqConfTusd;
    private javax.swing.JLabel txtValorConfTusd;
    private javax.swing.JLabel txtValorTotalTusd;
    private javax.swing.JLabel txtTarAplicTE;
    private javax.swing.JLabel txtValorFornTE;
    private javax.swing.JLabel txtTarImpostoTE;
    private javax.swing.JLabel txtBaseCalIcmsTE;
    private javax.swing.JLabel txtValorIcmsTE;
    private javax.swing.JLabel txtBCalcPisCofTE;
    private javax.swing.JLabel txtAliqPisTE;
    private javax.swing.JLabel txtValorPisTE;
    private javax.swing.JLabel txtAliqCofTE;
    private javax.swing.JLabel txtValorCofTE;
    private javax.swing.JLabel txtValorTotalTE;
    private javax.swing.JLabel txtCIP;
    private javax.swing.JLabel txtJurosMora;
    private javax.swing.JLabel txtOutroValores;
    private javax.swing.JLabel txtValorFornVT;
    private javax.swing.JLabel txtBCalIcmsVT;
    private javax.swing.JLabel txtValorIcmsVT;
    private javax.swing.JLabel txtBCalcPisCofVT;
    private javax.swing.JLabel txtValorPisVT;
    private javax.swing.JLabel txtValorCofVT;
    private javax.swing.JLabel txtPisTributo;
    private javax.swing.JLabel txtCofTributo;
    private javax.swing.JLabel txtIcmsTributo;
    private javax.swing.JLabel txCodBarras;

}

