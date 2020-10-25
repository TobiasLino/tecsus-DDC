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
}
