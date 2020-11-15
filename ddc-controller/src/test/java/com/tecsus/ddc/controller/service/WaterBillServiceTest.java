package com.tecsus.ddc.controller.service;

import com.tecsus.ddc.bills.water.WaterBill;
import com.tecsus.ddc.controller.connector.ConnectionImpl;
import com.tecsus.ddc.controller.connector.Connector;
import com.tecsus.ddc.controller.repository.WaterBillRepository;
import com.tecsus.ddc.factory.WaterBillFactory;
import com.tecsus.ddc.query.WaterBillQueryFactory;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;

/**
 * @author TOBIASDASILVALINO
 */
public class WaterBillServiceTest {

    private final WaterBillRepository waterBillRepository;

    public WaterBillServiceTest() {
        Connector connector = new Connector().connect();
        ConnectionImpl connection = connector.getConnection();
        this.waterBillRepository = new WaterBillRepository(connection, new WaterBillQueryFactory(), new WaterBillFactory());
    }

    @Test
    public void findAllTest() {
        WaterBillService service = new WaterBillService(waterBillRepository);

        List<WaterBill> list = service.findAll();
        list.forEach(System.out::println);
    }

    @Test
    public void findByIdTest() {
        WaterBillService service = new WaterBillService(waterBillRepository);

        Optional<WaterBill> billOptional = service.findById("12345678910");
        if (billOptional.isPresent()) {
            WaterBill bill = billOptional.get();
            assertEquals("12281505", bill.getBill().getInstalation().getAddress().getZip());
        }
    }
}
