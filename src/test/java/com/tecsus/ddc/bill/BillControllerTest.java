package com.tecsus.ddc.bill;

import com.tecsus.ddc.bill.type.BillType;
import com.tecsus.ddc.connection.Connector;
import com.tecsus.ddc.instalation.Instalation;
import com.tecsus.ddc.meter.Meter;
import com.tecsus.ddc.register.Register;
import com.tecsus.ddc.register.RegisterController;
import com.tecsus.ddc.register.RegisterRepository;
import com.tecsus.ddc.security.SecurityContext;
import com.tecsus.ddc.security.SecurityContextFactory;
import com.tecsus.ddc.security.WithUser;
import com.tecsus.ddc.user.LoggedUser;
import com.tecsus.ddc.user.Role;
import com.tecsus.ddc.user.User;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class BillControllerTest {

    @Before
    public void initialize() {
        LoggedUser loggedUser = new LoggedUser();
        User user = simpleUser();
        loggedUser.setUser(user);
        SecurityContext.loggedUser = loggedUser;
    }

    @Test
    @WithUser
    public void saveTest() {
        Connector connector = new Connector();
        BillController controller = new BillController(connector.getConnection());
        RegisterController registerController = new RegisterController(new RegisterRepository(connector.getConnection()));

        System.out.println(SecurityContext.loggedUser.getUser());

        final Bill bill = simpleBill();
        final Register register = Register.builder()
                .user(SecurityContext.loggedUser.getUser())
                .bill(bill)
                .instalation(bill.getInstalation())
                .build();

        controller.save(bill);
        registerController.save(register);
    }

    private Bill simpleBill() {
        return Bill.builder()
                .billType(BillType.ENERGY)
                .instalation(Instalation.builder().instalationNumber("2599675-4").build())
                .billNum("12345")
                .meter(Meter.builder().meterNumber("A18LM0552278").build())
                .refMonth(new Date())
                .value(new BigDecimal("200"))
                .actualRead(new Date())
                .actualReadValue(new BigDecimal("200"))
                .previousRead(new Date())
                .previousReadValue(new BigDecimal("150.0"))
                .nextRead(new Date())
                .dueDate(new Date())
                .consum(150)
                .consumPeriod(30)
                .build();
    }

    private User simpleUser() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(Role.ADMIN);
        return User.builder()
                .login("tslino")
                .username("Tobias Lino")
                .password("123")
                .roles(roles)
                .build();
    }
}
