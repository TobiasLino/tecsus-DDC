package com.tecsus.ddc.view.frames.generator;

import com.tecsus.ddc.bills.Bill;
import com.tecsus.ddc.bills.energy.Classe;
import com.tecsus.ddc.bills.energy.EnergyBill;
import com.tecsus.ddc.bills.energy.Group;
import com.tecsus.ddc.bills.energy.enums.*;
import com.tecsus.ddc.instalation.Instalation;
import com.tecsus.ddc.view.frames.energy.*;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;

import javax.swing.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
                            .classe(Classes.valueOf(fields.getTxtClasse().getText()))
                            .subClasses(SubClasses.valueOf(fields.getTxtSubclasse().getText()))
                            .build())
                    .group(Group.builder()
                            .group(Groups.valueOf(fields.getTxtGrupo().getText()))
                            .subGroup(Subgroups.valueOf(fields.getTxtSubgrupo().getText()))
                            .build())
                    .modalitie(Modalities.valueOf(fields.getTxtTipoBandeira().getText()))
                    .consumption(new BigDecimal((fields.getTxtConsumoKwhMes().getText())))
                    .tension(Integer.parseInt(fields.getTxtTensaoNominal().getText()))
                    .emission(new DateTime(format.parse(fields.getTxtEmissaoFatura().getText())))
                    .icms(new BigDecimal(fields.getTxtValorICMS().getText()))
                    .financialItems(new BigDecimal(fields.getTxtCIPMunicipal().getText()))
                    .supplyType(SupplyType.valueOf(fields.getTxtTipoFornecimento().getText()))
                    .tributes(calculaTributos(fields))
                    .billing(constructProduct(fields))
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

    static private List<product> constructProduct(EnergyBillFormTextFields fields)
    {

        List<product> products = new ArrayList();

        for(int i = 0; i < fields.tblFaturamento.getRowCount(); i++)
        {

            Product p = Product.builder()
                    .desc((String) fields.tblFaturamento.getModel().getValueAt(i, 1))
                    .valForn(new BigDecimal ((String) fields.tblFaturamento.getModel().getValueAt(i, 2)))
                    .valTot(new BigDecimal ((String) fields.tblFaturamento.getModel().getValueAt(i, 3)))
                    .build();

            products.add(p);

        }

        return products;

    }

}

