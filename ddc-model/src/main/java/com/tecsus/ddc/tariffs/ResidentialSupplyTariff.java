package com.tecsus.ddc.tariffs;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

/**
 * Representa as tarifas divulgadas pela ANEEL para contas de energia
 * @author TOBIASDASILVALINO
 */
@NoArgsConstructor
@Data
@Builder
public class ResidentialSupplyTariff {

    private int ideTarifaFornecimento;
    private String nomConcessao;
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
}
