package com.tecsus.ddc.view.frames.generator;

import com.sun.corba.se.impl.ior.ObjectIdImpl;
import com.tecsus.ddc.bills.Bill;
import com.tecsus.ddc.bills.energy.Classe;
import com.tecsus.ddc.bills.energy.EnergyBill;
import com.tecsus.ddc.bills.energy.Group;
import com.tecsus.ddc.bills.energy.TariffFlag;
import com.tecsus.ddc.bills.energy.Product;
import com.tecsus.ddc.bills.energy.enums.*;
import com.tecsus.ddc.instalation.Instalation;
import com.tecsus.ddc.view.frames.energy.EnergyBillFormTextFields;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;

import javax.swing.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class EnergyBillGenerator {
    
    private EnergyBillGenerator() {}

    public static EnergyBill generate(EnergyBillFormTextFields fields, final JTable productsTable, final JTable tariffFlagsTable) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
        SimpleDateFormat refMonthFormatter = new SimpleDateFormat("MM/YYYY");
        EnergyBill res = null;
        log.info("Generating energy bill");
        try {   // Trying to parse data types
            String billNum = fields.getTxtCodIdentificacao().getText();
            res =  EnergyBill.builder()
                    .bill(Bill.builder()
                            .instalation(
                                    Instalation.builder()
                                            .numInst(fields.getTxtNumeroInstalacao().getText())
                                            .build())
                            .numConta(billNum)
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

            for (TariffFlag tariffFlag : constructTariffFlags(tariffFlagsTable, billNum))
                res.addTariffFlag(tariffFlag);

            for (final Product p : constructProduct(productsTable, billNum))
                res.addProduct(p);

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

    static private List<Product> constructProduct(final JTable productsTable, final String billNum) {
        List<Product> products = new ArrayList<>();

        for(int i = 0; i < productsTable.getRowCount(); ++i) {
            Product p = Product.builder()
                    .description((String) productsTable.getModel().getValueAt(i, 1))
                    .fornecValue(new BigDecimal((String) productsTable.getModel().getValueAt(i, 2)))
                    .kWhQuantity(new BigDecimal((String) productsTable.getModel().getValueAt(i, 3)))
                    .totalValue(new BigDecimal((String) productsTable.getModel().getValueAt(i, 4)))
                    .billNum(billNum)
                    .build();

            products.add(p);
        }

        return products;
    }

    static private List<TariffFlag> constructTariffFlags(final JTable flagsTable, final String billNum) throws ParseException {
        List<TariffFlag> tariffFlags = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");

        for (int i = 0; i < flagsTable.getRowCount(); ++i) {
            TariffFlag flag = TariffFlag.builder()
                    .idBill(billNum)
                    .flag(TariffFlags.valueOf((String) flagsTable.getModel().getValueAt(i, 1)))
                    .start(new DateTime(format.parse((String) flagsTable.getModel().getValueAt(i, 2))))
                    .finish(new DateTime(format.parse((String) flagsTable.getModel().getValueAt(i, 3))))
                    .build();

            tariffFlags.add(flag);
        }

        return tariffFlags;
    }
}
