package com.tecsus.ddc.tariffs;

import com.tecsus.ddc.dealership.enums.EnergyDealerships;
import com.tecsus.ddc.tariffs.enums.GrantNames;
import org.joda.time.DateTime;

import java.math.BigDecimal;

/**
 * Representa as tarifas divulgadas pela ANEEL para contas de energia
 * @author TOBIASDASILVALINO
 */
public class ResidentialSupplyTariff {

    private int ideTarifaFornecimento;
    private String nomConcessao;
    private EnergyDealerships dealership;
    private String sigDistribuidora;
    private String sigRegiao;
    private String sigUF;
    private String vlrTUSDConvencional;
    private String vlrTEConvencional;
    private String vlrTotaTRFConvencional;
    private String vlrTRFBrancaPonta;
    private String vlrTRFBrancaIntermediaria;
    private String vlrTRFBrancaForaPonta;
    private DateTime dthInicioVigencia;
    private String numResolucao;
    private DateTime dthProcessamento;


    public ResidentialSupplyTariff() {
    }


    public EnergyDealerships getDealership() {
        return dealership;
    }

    public void setDealership(final EnergyDealerships dealership) {
        this.dealership = dealership;
    }
}
