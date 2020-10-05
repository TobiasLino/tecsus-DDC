package com.tecsus.ddc.bills;

import com.tecsus.ddc.bills.client.ClientTest;
import com.tecsus.ddc.client.Client;
import com.tecsus.ddc.dealership.Dealership;
import com.tecsus.ddc.User;
import com.tecsus.ddc.builders.UserBuilder;
import com.tecsus.ddc.dealership.builders.DealershipBuilder;
import com.tecsus.ddc.dealership.enums.Dealerships;
import org.joda.time.DateTime;

import org.junit.Test;

/**
 * @author TOBIASDASILVALINO
 */
public class SavedBillTest {

    @Test
    public void savedBillBuilderTest() {
        final User user = new UserBuilder();
        final Client client = new ClientTest().buildClient();
        final Dealership dealership = new DealershipBuilder()
                .dealership(Dealerships.EDPSP)
                .build();

        final SavedBill sb = new SavedBill(
                user.getId(),
                user,
                dealership,
                client,
                bill,
                new DateTime());
    }
}
