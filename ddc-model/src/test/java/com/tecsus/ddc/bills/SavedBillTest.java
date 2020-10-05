package com.tecsus.ddc.bills;

import com.tecsus.ddc.Client;
import com.tecsus.ddc.Dealership;
import com.tecsus.ddc.User;
import com.tecsus.ddc.builders.DealershipBuilder;
import com.tecsus.ddc.builders.UserBuilder;
import org.joda.time.DateTime;
import org.junit.Test;

/**
 * @author TOBIASDASILVALINO
 */
public class SavedBillTest {

    @Test
    public void savedBillBuilderTest() {
        final User user = new UserBuilder();
        final Dealership dealership = new DealershipBuilder();
        Client client = new ClientBuilder();

        final SavedBill sb = new SavedBill(
                user.getId(),
                user,
                dealership,
                client,
                bill,
                new DateTime());
    }
}
