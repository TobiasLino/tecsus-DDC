package com.tecsus.ddc.view.frames.generator;

import com.tecsus.ddc.bills.Bill;
import com.tecsus.ddc.bills.energy.EnergyBill;
import com.tecsus.ddc.instalation.Instalation;
import com.tecsus.ddc.view.frames.energy.EnergyBillFormTextFields;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Slf4j
public class EnergyBillGenerator {
    
    private EnergyBillGenerator() {}

    public static EnergyBill generate(EnergyBillFormTextFields fields) {
        //throw new UnsupportedOperationException("Not supported yet.");
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
        SimpleDateFormat refMonthFormatter = new SimpleDateFormat("MM/YYYY");
        EnergyBill res = null;
        log.info("Generating energy bill");
        try {   // Trying to parse data types
            res =  EnergyBill.builder()
                    .bill(Bill.builder()
                            .instalation(
                                    Instalation.builder()
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
        log.info("Water bill generated");
        } catch (ParseException e) {
            e.printStackTrace();
            log.info("Water bill generation failed");
        }
        return res;//To change body of generated methods, choose Tools | Templates.
    }
}

