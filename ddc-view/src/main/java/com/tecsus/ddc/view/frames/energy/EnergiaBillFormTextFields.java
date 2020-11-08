package com.tecsus.ddc.view.frames.energy;

import javax.swing.*;

public class EnergiaBillFormTextFields {
    private JTextField txtEndereco;
    private JTextField txtNumEnd;
    private JTextField txtComplementoEnd;
    private JTextField txtCep;
    private JTextField txtCidade;
    private JTextField txtBairro;
//    private JComboBox cbxEstado;
    private JTextField txtCnpj;
    private JTextField txtRazao;
    private JTextField txtInsEstadual;
    private JTextField txtCliente;
    private JTextField txtCodIdent;
    private JTextField txtCodFisOp;
    private JTextField txtGrupoSubGrupo;
    private JTextField txtClaSubCla;
    private JTextField txtTipoFornecimento;
    private JTextField txtModTarifa;
    private JTextField txtRotLeitura;
    private JTextField txtTensNominal;
    private JTextField txtNmedidor;
    private JTextField txtNumInstal;
    private JTextField txtInicio;
    private JTextField txtFim;
    private JTextField txtTipoBandeira;
    private JTextField txtDiasBandeira;
    private JTextField txtContMes;
    private JTextField txtVenc;
    private JTextField txtConsumo;
    private JTextField txtValorTotalPagar;
    private JTextField txtDtLeitAnterior;
    private JTextField txtDtLeitAtual;
    private JTextField txtAnteriorHwh;
    private JTextField txtEmissao;
    private JTextField txtDiasFaturamento;
    private JTextField txtDtProxLeitura;
    private JTextField txtAtualKwh;
    private JTextField txtTarifaAplicTusd;
    private JTextField txtValorFornTusd;
    private JTextField txtTarifaImpostoTusd;
    private JTextField txtBCalcICMSTusd;
    private JTextField txtValorIcmsTusd;
    private JTextField txtBCalcPisCofTusd;
    private JTextField txtAliqPisTusd;
    private JTextField txtValorPisTusd;
    private JTextField txtAliqConfTusd;
    private JTextField txtValorConfTusd;
    private JTextField txtValorTotalTusd;
    private JTextField txtTarAplicTE;
    private JTextField txtValorFornTE;
    private JTextField txtTarImpostoTE;
    private JTextField txtBaseCalIcmsTE;
    private JTextField txtValorIcmsTE;
    private JTextField txtBCalcPisCofTE;
    private JTextField txtAliqPisTE;
    private JTextField txtValorPisTE;
    private JTextField txtAliqCofTE;
    private JTextField txtValorCofTE;
    private JTextField txtValorTotalTE;
    private JTextField txtCIP;
    private JTextField txtJurosMora;
    private JTextField txtOutroValores;
    private JTextField txtValorFornVT;
    private JTextField txtBCalIcmsVT;
    private JTextField txtValorIcmsVT;
    private JTextField txtBCalcPisCofVT;
    private JTextField txtValorPisVT;
    private JTextField txtValorCofVT;
    private JTextField txtPisTributo;
    private JTextField txtCofTributo;
    private JTextField txtIcmsTributo;
    private JTextField txCodBarras;
    private JButton btnSalvar;
    private JButton btnSair;

    public EnergiaBillFormTextFields() {
        this.txtEndereco = new JTextField();
        this.txtNumEnd = new JTextField();
        this.txtComplementoEnd = new JTextField();
        this.txtCep = new JTextField();
        this.txtCidade = new JTextField();
        this.txtBairro = new JTextField();
        this.txtCnpj = new JTextField();
        this.txtRazao = new JTextField();
        this.txtInsEstadual = new JTextField();
        this.txtCliente = new JTextField();
        this.txtCodIdent = new JTextField();
        this.txtCodFisOp = new JTextField();
        this.txtGrupoSubGrupo = new JTextField();
        this.txtClaSubCla = new JTextField();
        this.txtTipoFornecimento = new JTextField();
        this.txtModTarifa = new JTextField();
        this.txtRotLeitura = new JTextField();
        this.txtTensNominal = new JTextField();
        this.txtNmedidor = new JTextField();
        this.txtNumInstal = new JTextField();
        this.txtInicio = new JTextField();
        this.txtFim = new JTextField();
        this.txtTipoBandeira = new JTextField();
        this.txtDiasBandeira = new JTextField();
        this.txtContMes = new JTextField();
        this.txtVenc = new JTextField();
        this.txtConsumo = new JTextField();
        this.txtValorTotalPagar = new JTextField();
        this.txtDtLeitAnterior = new JTextField();
        this.txtDtLeitAtual = new JTextField();
        this.txtAnteriorHwh = new JTextField();
        this.txtEmissao = new JTextField();
        this.txtDiasFaturamento = new JTextField();
        this.txtDtProxLeitura = new JTextField();
        this.txtAtualKwh = new JTextField();
        this.txtTarifaAplicTusd = new JTextField();
        this.txtValorFornTusd = new JTextField();
        this.txtTarifaImpostoTusd = new JTextField();
        this.txtBCalcICMSTusd = new JTextField();
        this.txtValorIcmsTusd = new JTextField();
        this.txtBCalcPisCofTusd = new JTextField();
        this.txtAliqPisTusd = new JTextField();
        this.txtValorPisTusd = new JTextField();
        this.txtAliqConfTusd = new JTextField();
        this.txtValorConfTusd = new JTextField();
        this.txtValorTotalTusd = new JTextField();
        this.txtTarAplicTE = new JTextField();
        this.txtValorFornTE = new JTextField();
        this.txtTarImpostoTE = new JTextField();
        this.txtBaseCalIcmsTE = new JTextField();
        this.txtValorIcmsTE = new JTextField();
        this.txtBCalcPisCofTE = new JTextField();
        this.txtAliqPisTE = new JTextField();
        this.txtValorPisTE = new JTextField();
        this.txtAliqCofTE = new JTextField();
        this.txtValorCofTE = new JTextField();
        this.txtValorTotalTE = new JTextField();
        this.txtCIP = new JTextField();
        this.txtJurosMora = new JTextField();
        this.txtOutroValores = new JTextField();
        this.txtValorFornVT = new JTextField();
        this.txtBCalIcmsVT = new JTextField();
        this.txtValorIcmsVT = new JTextField();
        this.txtBCalcPisCofVT = new JTextField();
        this.txtValorPisVT = new JTextField();
        this.txtValorCofVT = new JTextField();
        this.txtPisTributo = new JTextField();
        this.txtCofTributo = new JTextField();
        this.txtIcmsTributo = new JTextField();
        this.txCodBarras = new JTextField();
        this.btnSair = new JButton();
        this.btnSalvar = new JButton();

    }

    public JTextField getTxtEndereco(){return txtEndereco;}
    public JTextField getTxtNumEnd(){return txtNumEnd;}
    public JTextField getTxtComplementoEnd(){return txtComplementoEnd;}
    public JTextField getTxtCep(){return txtCep;}
    public JTextField getTxtCidade(){return txtCidade;}
    public JTextField getTxtBairro(){return txtBairro;}
    public JTextField getTxtCnpj(){return txtCnpj;}
    public JTextField getTxtRazao(){return txtRazao;}
    public JTextField getTxtInsEstadual(){return txtInsEstadual;}
    public JTextField getTxtCliente(){return txtCliente;}
    public JTextField getTxtCodIdent(){return txtCodIdent;}
    public JTextField getTxtCodFisOp(){return txtCodFisOp;}
    public JTextField getTxtGrupoSubGrupo(){return txtGrupoSubGrupo;}
    public JTextField getTxtClaSubCla(){return txtClaSubCla;}
    public JTextField getTxtTipoFornecimento(){return txtTipoFornecimento;}
    public JTextField getTxtModTarifa(){return txtModTarifa;}
    public JTextField getTxtRotLeitura(){return txtRotLeitura;}
    public JTextField getTxtTensNominal(){return txtTensNominal;}
    public JTextField getTxtNmedidor(){return txtNmedidor;}
    public JTextField getTxtNumInstal(){return txtNumInstal;}
    public JTextField getTxtInicio(){return txtInicio;}
    public JTextField getTxtFim(){return txtFim;}
    public JTextField getTxtTipoBandeira(){return txtTipoBandeira;}
    public JTextField getTxtDiasBandeira(){return txtDiasBandeira;}
    public JTextField getTxtContMes(){return txtContMes;}
    public JTextField getTxtVenc(){return txtVenc;}
    public JTextField getTxtConsumo(){return txtConsumo;}
    public JTextField getTxtValorTotalPagar(){return txtValorTotalPagar;}
    public JTextField getTxtDtLeitAnterior(){return txtDtLeitAnterior;}
    public JTextField getTxtDtLeitAtual(){return txtDtLeitAtual;}
    public JTextField getTxtAnteriorHwh(){return txtAnteriorHwh;}
    public JTextField getTxtEmissao(){return txtEmissao;}
    public JTextField getTxtDiasFaturamento(){return txtDiasFaturamento;}
    public JTextField getTxtDtProxLeitura(){return txtDtProxLeitura;}
    public JTextField getTxtAtualKwh(){return txtAtualKwh;}
    public JTextField getTxtTarifaAplicTusd(){return txtTarifaAplicTusd;}
    public JTextField getTxtValorFornTusd(){return txtValorFornTusd;}
    public JTextField getTxtTarifaImpostoTusd(){return txtTarifaImpostoTusd;}
    public JTextField getTxtBCalcICMSTusd(){return txtBCalcICMSTusd;}
    public JTextField getTxtValorIcmsTusd(){return txtValorIcmsTusd;}
    public JTextField getTxtBCalcPisCofTusd(){return txtBCalcPisCofTusd;}
    public JTextField getTxtAliqPisTusd(){return txtAliqPisTusd;}
    public JTextField getTxtValorPisTusd(){return txtValorPisTusd;}
    public JTextField getTxtAliqConfTusd(){return txtAliqConfTusd;}
    public JTextField getTxtValorConfTusd(){return txtValorConfTusd;}
    public JTextField getTxtValorTotalTusd(){return txtValorTotalTusd;}
    public JTextField getTxtTarAplicTE(){return txtTarAplicTE;}
    public JTextField getTxtValorFornTE(){return txtValorFornTE;}
    public JTextField getTxtTarImpostoTE(){return txtTarImpostoTE;}
    public JTextField getTxtBaseCalIcmsTE(){return txtBaseCalIcmsTE;}
    public JTextField getTxtValorIcmsTE(){return txtValorIcmsTE;}
    public JTextField getTxtBCalcPisCofTE(){return txtBCalcPisCofTE;}
    public JTextField getTxtAliqPisTE(){return txtAliqPisTE;}
    public JTextField getTxtValorPisTE(){return txtValorPisTE;}
    public JTextField getTxtAliqCofTE(){return txtAliqCofTE;}
    public JTextField getTxtValorCofTE(){return txtValorCofTE;}
    public JTextField getTxtValorTotalTE(){return txtValorTotalTE;}
    public JTextField getTxtCIP(){return txtCIP;}
    public JTextField getTxtJurosMora(){return txtJurosMora;}
    public JTextField getTxtOutroValores(){return txtOutroValores;}
    public JTextField getTxtValorFornVT(){return txtValorFornVT;}
    public JTextField getTxtBCalIcmsVT(){return txtBCalIcmsVT;}
    public JTextField getTxtValorIcmsVT(){return txtValorIcmsVT;}
    public JTextField getTxtBCalcPisCofVT(){return txtBCalcPisCofVT;}
    public JTextField getTxtValorPisVT(){return txtValorPisVT;}
    public JTextField getTxtValorCofVT(){return txtValorCofVT;}
    public JTextField getTxtPisTributo(){return txtPisTributo;}
    public JTextField getTxtCofTributo(){return txtCofTributo;}
    public JTextField getTxtIcmsTributo(){return txtIcmsTributo;}
    public JTextField gettxCodBarras(){return txCodBarras;}

}
