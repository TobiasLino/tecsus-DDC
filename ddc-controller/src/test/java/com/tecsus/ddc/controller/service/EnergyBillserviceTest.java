package com.tecsus.ddc.controller.service;

import com.tecsus.ddc.bills.energy.EnergyBill;
import com.tecsus.ddc.controller.connector.Connector;
import org.junit.Test;

import java.util.List;

/**
 * @author TOBIASDASILVALINO
 */
public class EnergyBillserviceTest {

    @Test
    public void findAllTest() {
        EnergyBillService energyBillService = new EnergyBillService(new Connector());
        List<EnergyBill> list = energyBillService.findAll();
        list.forEach(eb -> System.out.println(eb));
    }
}
