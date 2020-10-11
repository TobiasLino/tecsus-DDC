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

    private int supplyTariffIdentification;
    private GrantNames grantName;
    private EnergyDealerships dealership;
    private BigDecimal TUSD;
    private BigDecimal TE;
    private BigDecimal totalTRF;
    private BigDecimal tipWhiteTariff;
    private BigDecimal intermediateWhiteTariff;
    private BigDecimal outTipWhiteTariff;
    private DateTime start;
    private DateTime processing;
}
