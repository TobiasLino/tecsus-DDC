package com.tecsus.ddc.controller.service;

import com.tecsus.ddc.bills.water.WaterBill;
import com.tecsus.ddc.controller.connector.Connector;
import org.junit.Test;

import java.util.List;

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
}
