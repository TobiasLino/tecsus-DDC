package com.tecsus.ddc.controller.service;

import com.tecsus.ddc.bills.energy.EnergyBill;
import com.tecsus.ddc.bills.energy.Product;
import com.tecsus.ddc.bills.energy.TariffFlag;
import com.tecsus.ddc.controller.connector.ConnectionImpl;
import com.tecsus.ddc.controller.connector.Connector;
import com.tecsus.ddc.controller.repository.EnergyBillRepository;
import com.tecsus.ddc.controller.repository.ProductRepository;
import com.tecsus.ddc.controller.repository.TariffFlagRepository;
import com.tecsus.ddc.query.EnergyBillQueryFactory;
import com.tecsus.ddc.query.ProductQueryFactory;
import com.tecsus.ddc.query.TariffFlagQueryFactory;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

public class EnergyBillServiceTest {

    private final static String ID_BILL = "2";

    private final EnergyBillRepository energyBillRepository;
    private final ProductRepository productRepository;
    private final TariffFlagRepository tariffFlagRepository;

    public EnergyBillServiceTest() {
        Connector connector = new Connector().connect();
        ConnectionImpl connection = connector.getConnection();
        this.energyBillRepository = new EnergyBillRepository(connection, new EnergyBillQueryFactory());
        this.productRepository = new ProductRepository(connection, new ProductQueryFactory());
        this.tariffFlagRepository = new TariffFlagRepository(connection, new TariffFlagQueryFactory());
    }

    @Test
    public void findById() {
        EnergyBillService energyBillService = new EnergyBillService(energyBillRepository);
        TariffFlagService tariffFlagService = new TariffFlagService(tariffFlagRepository);
        ProductService productService = new ProductService(productRepository);

        Optional<EnergyBill> energyBillOptional = energyBillService.findById(ID_BILL);
        List<Product> products = productService.findAllById(ID_BILL);
        List<TariffFlag> tariffFlags = tariffFlagService.findAll(ID_BILL);

        energyBillOptional.ifPresent(energyBill -> {
            products.forEach(energyBill::addProduct);
            tariffFlags.forEach(energyBill::addTariffFlag);
        });

        System.out.println("TEST FINISHED");
    }
}
