package com.tecsus.ddc.controller.service;

import com.tecsus.ddc.factory.*;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class EnergyBillServiceTest {

    private final static String ID_BILL = "2";

    private final EnergyBillRepository energyBillRepository;
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
    }

    @Test
    public void findById() {
        TariffFlagService tariffFlagService = new TariffFlagService(tariffFlagRepository);
        ProductService productService = new ProductService(productRepository);
        EnergyBillService energyBillService = new EnergyBillService(energyBillRepository, productRepository, tariffFlagRepository);

        Optional<EnergyBill> energyBillOptional = energyBillService.findById(ID_BILL);
        List<Product> products = productService.findAllById(ID_BILL);
        List<TariffFlag> tariffFlags = tariffFlagService.findAll(ID_BILL);

        energyBillOptional.ifPresent(energyBill -> {
            products.forEach(energyBill::addProduct);
            tariffFlags.forEach(energyBill::addTariffFlag);
        });
    }

    private Map<String, Factory> factories() {
        Map<String, Factory> factoryMap = new HashMap<>();
        factoryMap.put("instalation", new InstalationFactory());
        factoryMap.put("bill", new BillFactory());
        factoryMap.put("energy_bill", new EnergyBillFactory());
        return factoryMap;
    }
}
