package com.tecsus.ddc.controller.service;

import com.tecsus.ddc.bills.Bill;
import com.tecsus.ddc.bills.energy.*;
import com.tecsus.ddc.bills.energy.enums.*;
import com.tecsus.ddc.controller.connector.ConnectionImpl;
import com.tecsus.ddc.controller.connector.Connector;
import com.tecsus.ddc.controller.repository.BillRepository;
import com.tecsus.ddc.controller.repository.EnergyBillRepository;
import com.tecsus.ddc.controller.repository.ProductRepository;
import com.tecsus.ddc.controller.repository.TariffFlagRepository;
import com.tecsus.ddc.factory.*;
import com.tecsus.ddc.instalation.Instalation;
import com.tecsus.ddc.query.EnergyBillQueryFactory;
import com.tecsus.ddc.query.ProductQueryFactory;
import com.tecsus.ddc.query.TariffFlagQueryFactory;
import com.tecsus.ddc.query.AbstractBillQueryFactory;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class EnergyBillServiceTest {

    private final static String ID_BILL = "2";

    private final EnergyBillRepository energyBillRepository;
    private final BillRepository billRepository;
    private final ProductRepository productRepository;
    private final TariffFlagRepository tariffFlagRepository;

    public EnergyBillServiceTest() {
        Connector connector = new Connector().connect();
        ConnectionImpl connection = connector.getConnection();

        this.energyBillRepository = new EnergyBillRepository(
                connection,
                new EnergyBillQueryFactory(),
                new EnergyBillFactory(),
                new BillFactory());

        this.productRepository = new ProductRepository(connection, new ProductQueryFactory(), new ProductFactory());

        this.tariffFlagRepository = new TariffFlagRepository(connection, new TariffFlagQueryFactory(), new TariffFlagFactory());

        this.billRepository = new BillRepository(connection, new AbstractBillQueryFactory(), new BillFactory());
    }

    @Test
    public void findById() {
        TariffFlagService tariffFlagService = new TariffFlagService(tariffFlagRepository);
        ProductService productService = new ProductService(productRepository);
        EnergyBillService energyBillService = new EnergyBillService(energyBillRepository,billRepository ,productRepository, tariffFlagRepository);

        Optional<EnergyBill> energyBillOptional = energyBillService.findById(ID_BILL);
        List<Product> products = productService.findAllById(ID_BILL);
        List<TariffFlag> tariffFlags = tariffFlagService.findAll(ID_BILL);

        energyBillOptional.ifPresent(energyBill -> {
            products.forEach(energyBill::addProduct);
            tariffFlags.forEach(energyBill::addTariffFlag);
        });
    }
    @Test
    public void insert(){
        TariffFlagService tariffFlagService = new TariffFlagService(tariffFlagRepository);
        ProductService productService = new ProductService(productRepository);
        EnergyBillService energyBillService = new EnergyBillService(energyBillRepository,billRepository ,productRepository, tariffFlagRepository);


        EnergyBill energyBill = simpleEnergyBill();
        energyBillService.insert(energyBill);

        Optional<EnergyBill> energyBillOptional = energyBillService.findById(ID_BILL);
        List<Product> products = productService.findAllById(ID_BILL);
        List<TariffFlag> tariffFlags = tariffFlagService.findAll(ID_BILL);

        energyBillOptional.ifPresent(bill -> {
            products.forEach(bill::addProduct);
            tariffFlags.forEach(bill::addTariffFlag);
        });
        energyBillOptional.ifPresent(System.out::println());
    }

    private EnergyBill simpleEnergyBill() {
        return EnergyBill.builder()
                .bill(Bill.builder()
                        .instalation(
                                Instalation.builder()
                                        .numInst("150822041")
                                        .build())
                        .numConta("468555999889")
                        .valor(new BigDecimal("233.99"))
                        .vencimento(new DateTime().withDate(2020,11,15))
                        .mesReferencia(new DateTime().withDate(2020,10,01))
                        .periodoConsumo(29) // TODO insert this
                        .leituraAnterior(new DateTime().withDate(2020,9,15))
                        .leituraAtual(new DateTime().withDate(2020,11,15))
                        .leituraProxima(new DateTime().withDate(2020,12,15))
                        .valorLeituraAnterior(new BigDecimal("01.56"))
                        .valorLeituraAtual(new BigDecimal("02.57"))
                        .numMedidor("2036532645")
                        .build())
                .consumption( new BigDecimal("230"))
                .tension(235)
                .emission(new DateTime().withDate(2020,11,10))
                .icms(new BigDecimal("0.35"))
                .tributes(new BigDecimal("1.56"))
                .financialItems(new BigDecimal("25.33"))
                .supplyType(SupplyType.BIFASICO)
                .group(Group.builder()
                        .group(Groups.A)
                        .subGroup(Subgroups.A2)
                        .build())
                .classe(Classe.builder()
                        .classe(Classes.INDUSTRIAL)
                        .subClasses(SubClasses.RESIDENCIAL)
                        .build())
                .modalitie(Modalities.VERDE)
                .build();
    }
}
