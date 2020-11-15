package com.tecsus.ddc.controller.service;

import com.tecsus.ddc.bills.energy.TariffFlag;
import com.tecsus.ddc.controller.connector.ConnectionImpl;
import com.tecsus.ddc.controller.connector.Connector;
import com.tecsus.ddc.controller.repository.TariffFlagRepository;
import com.tecsus.ddc.factory.TariffFlagFactory;
import com.tecsus.ddc.query.TariffFlagQueryFactory;
import org.junit.Test;

import java.util.List;

public class TariffFlagServiceTest {

    private final TariffFlagRepository tariffFlagRepository;

    public TariffFlagServiceTest() {
        Connector connector = new Connector().connect();
        ConnectionImpl connection = connector.getConnection();
        this.tariffFlagRepository = new TariffFlagRepository(connection, new TariffFlagQueryFactory(), new TariffFlagFactory());
    }

    @Test
    public void tariffFlagList() {
        TariffFlagService service = new TariffFlagService(tariffFlagRepository);

        List<TariffFlag> tariffFlags = service.findAll("2");
        tariffFlags.forEach(System.out::println);
    }
}
