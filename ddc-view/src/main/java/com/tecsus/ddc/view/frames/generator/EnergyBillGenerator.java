package com.tecsus.ddc.view.frames.generator;

import com.tecsus.ddc.bills.Bill;
import com.tecsus.ddc.bills.energy.Classe;
import com.tecsus.ddc.bills.energy.EnergyBill;
import com.tecsus.ddc.bills.energy.Group;
import com.tecsus.ddc.bills.energy.enums.*;
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
                                            .numInst(fields.getTxtNumeroInstalacao().getText())
                                            .build())
                            .numConta(fields.getTxtCodIdentificacao().getText())
                            .valor(new BigDecimal(fields.getTxtValorTotalPagar().getText()))
                            .vencimento(new DateTime(format.parse(fields.getTxtDataVencimento().getText())))
                            .mesReferencia(new DateTime(refMonthFormatter.parse(fields.getTxtContaMes().getText())))
                            .periodoConsumo(Integer.parseInt(fields.getTxtDiasFatura().getText()))
                            .leituraAnterior(new DateTime(format.parse(fields.getTxtDataLeitAnterior().getText())))
                            .leituraAtual(new DateTime(format.parse(fields.getTxtDataLeitAtual().getText())))
                            .leituraProxima(new DateTime(format.parse(fields.getTxtDataLeitProxima().getText())))
                            .valorLeituraAnterior(new BigDecimal(fields.getTxtLeituraAntKwh().getText()))
                            .valorLeituraAtual(new BigDecimal(fields.getTxtLeituraAtualKwh().getText()))
                            .numMedidor(fields.getTxtNumeroMedidor().getText())
                            .build())
                    .classe(Classe.builder()
                            .classe(Classes.valueOf(fields.getTxtClasseSubclasse().getText()))
                            .subClasses(SubClasses.valueOf(fields.getTxtClasseSubclasse().getText()))
                            .build())
                    .group(Group.builder()
                            .group(Groups.valueOf(fields.getTxtGrupoSubgrupo().getText()))
                            .subGroup(Subgroups.valueOf(fields.getTxtGrupoSubgrupo().getText()))
                            .build())
                    .modalitie(Modalities.valueOf(fields.getTxtTipoBandeira().getText()))
                    .consumption(new BigDecimal((fields.getTxtConsumoKwhMes().getText())))
                    .tension(Integer.parseInt(fields.getTxtTensaoNominal().getText()))
                    .emission(new DateTime(format.parse(fields.getTxtEmissaoFatura().getText())))
                    .icms(new BigDecimal(fields.getTxtValorICMS().getText()))
                    .financialItems(new BigDecimal(fields.getTxtCIPMunicipal().getText()))
                    .supplyType(SupplyType.valueOf(fields.getTxtTipoFornecimento().getText()))
                    .tributes(calculaTributos(fields))
                    .build();
        log.info("Energy bill generated");
        } catch (ParseException e) {
            e.printStackTrace();
            log.info("Energy bill generation failed");
        }
        return res;//To change body of generated methods, choose Tools | Templates.
    }

    static private BigDecimal calculaTributos (EnergyBillFormTextFields fields) {
        BigDecimal pis = new BigDecimal(fields.getTxtValorPIS().getText());
        BigDecimal cofins = new BigDecimal(fields.getTxtValorCofins().getText());
        return pis.add(cofins);
    }
}

