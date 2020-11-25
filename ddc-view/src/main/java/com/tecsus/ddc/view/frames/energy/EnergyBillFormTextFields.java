package com.tecsus.ddc.view.frames.energy;

import lombok.Getter;

import javax.swing.*;

@Getter
public class EnergyBillFormTextFields {
    
    private final JTextField txtBairroEnd;
    private final JTextField txtCepEnd;
    private final JTextField txtCidadeEnd;
    private final JTextField txtCIPMunicipal;
    private final JTextField txtClasse;
    private final JTextField txtCodFiscalOperacao;
    private final JTextField txtCodIdentificacao;
    private final JTextField txtComplementoEnd;
    private final JTextField txtConsumoKwhMes;
    private final JTextField txtContaMes;
    private final JTextField txtCpfCnpj;
    private final JTextField txtDataFinalBandeira;
    private final JTextField txtDataInicioBandeira;
    private final JTextField txtDataLeitAnterior;
    private final JTextField txtDataLeitAtual;
    private final JTextField txtDataLeitProxima;
    private final JTextField txtDataVencimento;
    private final JTextField txtDiasFatura;
    private final JTextField txtEmissaoFatura;
    private final JTextField txtEndereco;
    private final JTextField txtGrupo;
    private final JTextField txtInsEstadual;
    private final JTextField txtLeituraAntKwh;
    private final JTextField txtLeituraAtualKwh;
    private final JTextField txtModalidadeTarifa;
    private final JTextField txtNomeClienteEnd;
    private final JTextField txtNumeroEnd;
    private final JTextField txtNumeroInstalacao;
    private final JTextField txtNumeroMedidor;
    private final JTextField txtRazaoSocial;
    private final JTextField txtRoteiroLeitura;
    private final JTextField txtSubclasse;
    private final JTextField txtSubgrupo;
    private final JTextField txtTensaoNominal;
    private final JTextField txtTipoBandeira;
    private final JTextField txtTipoFornecimento;
    private final JTextField txtValorCofins;
    private final JTextField txtValorFornecido;
    private final JTextField txtValorICMS;
    private final JTextField txtValorPIS;
    private final JTextField txtValorTotalFatura;
    private final JTextField txtValorTotalPagar;
    public final JTable tblFaturamento;

//    private final JComboBox cbxEstadoEnd;
//    private final JComboBox cbxDescicaoFatura;

    public EnergyBillFormTextFields() {
        this.txtBairroEnd = new JTextField();
        this.txtCepEnd = new JTextField();
        this.txtCidadeEnd = new JTextField();
        this.txtCIPMunicipal = new JTextField();
        this.txtClasse = new JTextField();
        this.txtCodFiscalOperacao = new JTextField();
        this.txtCodIdentificacao = new JTextField();
        this.txtComplementoEnd = new JTextField();
        this.txtConsumoKwhMes = new JTextField();
        this.txtContaMes = new JTextField();
        this.txtCpfCnpj = new JTextField();
        this.txtDataFinalBandeira = new JTextField();
        this.txtDataInicioBandeira = new JTextField();
        this.txtDataLeitAnterior = new JTextField();
        this.txtDataLeitAtual = new JTextField();
        this.txtDataLeitProxima = new JTextField();
        this.txtDataVencimento = new JTextField();
        this.txtDiasFatura = new JTextField();
        this.txtEmissaoFatura = new JTextField();
        this.txtEndereco = new JTextField();
        this.txtGrupo = new JTextField();
        this.txtInsEstadual = new JTextField();
        this.txtLeituraAntKwh = new JTextField();
        this.txtLeituraAtualKwh = new JTextField();
        this.txtModalidadeTarifa = new JTextField();
        this.txtNomeClienteEnd = new JTextField();
        this.txtNumeroEnd = new JTextField();
        this.txtNumeroInstalacao = new JTextField();
        this.txtNumeroMedidor = new JTextField();
        this.txtRazaoSocial = new JTextField();
        this.txtRoteiroLeitura = new JTextField();
        this.txtSubclasse = new JTextField();
        this.txtSubgrupo = new JTextField();
        this.txtTensaoNominal = new JTextField();
        this.txtTipoBandeira = new JTextField();
        this.txtTipoFornecimento = new JTextField();
        this.txtValorCofins = new JTextField();
        this.txtValorFornecido = new JTextField();
        this.txtValorICMS = new JTextField();
        this.txtValorPIS = new JTextField();
        this.txtValorTotalFatura = new JTextField();
        this.txtValorTotalPagar = new JTextField();
        this.tblFaturamento = new JTable();

//        this.cbxEstadoEnd = new JComboBox();
//        this.cbxDescicaoFatura = new JComboBox();
    }
}
