package com.tecsus.ddc.bills;

import com.tecsus.ddc.bills.client.ClientTest;
import com.tecsus.ddc.bills.water.WaterBill;
import com.tecsus.ddc.bills.water.builders.WaterBillBuilder;
import com.tecsus.ddc.bills.water.enums.WaterBillType;
import com.tecsus.ddc.client.Client;
import com.tecsus.ddc.dealership.Dealership;
import com.tecsus.ddc.user.User;
import com.tecsus.ddc.dealership.builders.DealershipBuilder;
import com.tecsus.ddc.dealership.enums.EnergyDealerships;
import com.tecsus.ddc.user.builders.UserBuilder;
import com.tecsus.ddc.user.enums.Role;
import org.joda.time.DateTime;

import org.junit.Test;

/**
 * @author TOBIASDASILVALINO
 */
public class SavedBillTest {

    @Test
    public void savedBillWaterBillTest() {
        final User user = new UserBuilder()
                .name("Tobias Lino")
                .username("tslino")
                .passwd("senha")
                .role(Role.ADMIN)
                .build();

        final Client client = new ClientTest().buildClient();

        final Dealership dealership = new DealershipBuilder()
                .name(EnergyDealerships.EDPSP)
                .build();

        final WaterBill bill = new WaterBillBuilder()
                .cod(12354678)
                .consumption(21)
                .hydrometer("Y15T0300225")
                .RGI("08744895/55")
                .residentialTotal(122.57)
                .type(WaterBillType.AGUA_ESGOTO)
                .water(68.29)
                .sewer(54.28)
                .TRCF(0.61)
                .build();

        final SavedBill sb = new SavedBill(
                user.getUsername(),
                user,
                dealership,
                client,
                bill,
                new DateTime());

        System.out.println(sb.toString());
    }
}
