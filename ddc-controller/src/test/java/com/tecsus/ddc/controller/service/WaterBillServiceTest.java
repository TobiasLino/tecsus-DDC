package com.tecsus.ddc.controller.service;

import com.tecsus.ddc.bills.builders.BillBuilder;
import com.tecsus.ddc.bills.water.WaterBill;
import com.tecsus.ddc.bills.water.builders.WaterBillBuilder;
import com.tecsus.ddc.bills.water.enums.BillingType;
import com.tecsus.ddc.bills.water.enums.ConnectionType;
import com.tecsus.ddc.client.builders.ClientBuilder;
import com.tecsus.ddc.controller.connector.Connector;
import com.tecsus.ddc.dealership.builders.DealershipBuilder;
import com.tecsus.ddc.instalation.builders.AddressBuilder;
import com.tecsus.ddc.instalation.builders.InstalationBuilder;
import org.joda.time.DateTime;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * @author TOBIASDASILVALINO
 */
public class WaterBillServiceTest {

    @Test
    public void findAllTest() {
        WaterBillService service = new WaterBillService(new Connector());
        List<WaterBill> list = service.findAll();
        list.forEach(wb -> System.out.println(wb));
    }

    @Test
    public void findByIdTest() {
        WaterBillService service = new WaterBillService(new Connector());
        Optional<WaterBill> bill = service.findById("1489087448951");
        if (bill.isPresent()) {
            System.out.println(bill.get());
        }
    }

    @Test
    public void insertTest() {
        WaterBill waterBill = constructBill();
        AbstractBillService abstractBillService = new AbstractBillService(new Connector());
        abstractBillService.insert(waterBill.getBill());
        WaterBillService service = new WaterBillService(new Connector());
        service.insert(waterBill);
    }

    public WaterBill constructBill() {
        return WaterBillBuilder.aWaterBill()
            .bill(
                new BillBuilder().instalation(
                    InstalationBuilder.anInstalation()
                        .numInst("0874489555")
                        .address(
                            AddressBuilder.anAddress()
                                .zip("12289456")
                                .street("Av. José Otávio de Macedo")
                                .complement("")
                                .num("615")
                                .neighborhood("Jd. Panorama")
                                .city("Caçapava")
                                .uf("SP")
                                .build()
                        )
                        .client(
                            ClientBuilder.aClient()
                                .name("GLOBO COMUNICACAO E PARTICIPACOES S/A")
                                .CNPJ("27865757000102")
                                .build()
                        )
                        .dealership(
                            DealershipBuilder.aDealership()
                                .id(1)
                                .CNPJ("02302100000106")
                                .initials("SABESP")
                                .site("www.edponline.com.br")
                                .build()
                        )
                        .build())
                .numConta("1480087448951")
                .valor(new BigDecimal("132.66"))
                .vencimento(new DateTime().withDate(2019,12,3))
                .mesReferencia(new DateTime().withDate(2019,12,1))
                .periodoConsumo(31)
                .leituraAnterior(new DateTime().withDate(2019,10,18))
                .leituraAtual(new DateTime().withDate(2019,11,18))
                .leituraProxima(new DateTime().withDate(2019,12,19))
                .valorleituraAnterior(new BigDecimal("211"))
                .valorleituraAtual(new BigDecimal("233"))
                .build())
            .conType(ConnectionType.AGUA_E_ESGOTO)
            .billingType(BillingType.COMUM)
            .consum(new BigDecimal("22"))
            .water(new BigDecimal("73.90"))
            .sewer(new BigDecimal("58.76"))
            .trcf(new BigDecimal("0.66"))
            .tributes(new BigDecimal("8.74"))
            .build();
    }
}
