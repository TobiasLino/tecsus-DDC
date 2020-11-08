package com.tecsus.ddc.view.frames.generator;

import com.tecsus.ddc.bills.builders.BillBuilder;
import com.tecsus.ddc.bills.water.WaterBill;
import com.tecsus.ddc.bills.water.builders.WaterBillBuilder;
import com.tecsus.ddc.bills.water.enums.BillingType;
import com.tecsus.ddc.bills.water.enums.ConnectionType;
import com.tecsus.ddc.instalation.builders.InstalationBuilder;
import com.tecsus.ddc.view.frames.water.WaterBillFormTextFields;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author RuanCesar
 */
public class EnergyBillGenerator {

    private EnergyBillGenerator() {}
    private final static Logger log = LoggerFactory.getLogger(EnergyBillGenerator.class);

    public static EnergyBill generate( EnergyBillFormTextFields fields) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
        SimpleDateFormat refMonthFormatter = new SimpleDateFormat("MM/YYYY");
        EnergyBill res = null;
        log.info("Generating energy bill");
        try {   // Trying to parse data types
            res =  EnergyBillBuilder.aEnergyBill()
                    .bill(new BillBuilder()
                            .instalation(
                                    InstalationBuilder.anInstalation()
                                            .numInst(fields.getTxtRgi().getText())
                                            .build())
                            .numConta(fields.getTxtNConta().getText())
                            .valor(new BigDecimal(fields.getTxtTotal().getText()))
                            .vencimento(new DateTime(format.parse(fields.getTxtVenc().getText())))
                            .mesReferencia(new DateTime(refMonthFormatter.parse(fields.getTxtMesRef().getText())))
                            .periodoConsumo(30) // TODO insert this
                            .leituraAnterior(new DateTime(format.parse(fields.getTxtLAnterior().getText())))
                            .leituraAtual(new DateTime(format.parse(fields.getTxtLAtual().getText())))
                            .leituraProxima(new DateTime(format.parse(fields.getTxtLProxima().getText())))
                            .valorleituraAnterior(new BigDecimal(fields.getTxtAnterior().getText()))
                            .valorleituraAtual(new BigDecimal(fields.getTxtAtual().getText()))
                            .numMedidor(fields.getTxtMedidor().getText())
                            .build())
                    .conType(ConnectionType.valueOf(fields.getTxtConexao().getText()))
                    .billingType(BillingType.valueOf("COMUM"))
                    .consum(new BigDecimal(fields.getTxtBCalculo().getText())) // TODO fix this funcking shit now
                    .water(new BigDecimal(fields.getTxtAgua().getText()))
                    .sewer(new BigDecimal(fields.getTxtEsgoto().getText()))
                    .trcf(new BigDecimal(fields.getTxtTrcf().getText()))
                    .tributes(new BigDecimal(fields.getTxtTributo().getText()))
                    .build();
            log.info("Energy bill generated");
        } catch (ParseException e) {
            e.printStackTrace();
            log.info("Energy bill generation failed");
        }
        return res;
    }
}

