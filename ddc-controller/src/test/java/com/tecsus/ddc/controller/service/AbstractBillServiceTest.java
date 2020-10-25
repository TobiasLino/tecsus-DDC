package com.tecsus.ddc.controller.service;

import com.tecsus.ddc.bills.Bill;
import com.tecsus.ddc.bills.builders.BillBuilder;
import com.tecsus.ddc.client.builders.ClientBuilder;
import com.tecsus.ddc.controller.connector.Connector;
import com.tecsus.ddc.dealership.builders.DealershipBuilder;
import com.tecsus.ddc.instalation.builders.AddressBuilder;
import com.tecsus.ddc.instalation.builders.InstalationBuilder;
import org.joda.time.DateTime;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import javax.ejb.ObjectNotFoundException;
import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author TOBIASDASILVALINO
 */
public class AbstractBillServiceTest {

    final static String NUM_CONTA = "1487087448951";


    @Test
    public void checkIfInsertedBillIsTheSameAsTheSelected() throws ObjectNotFoundException {
        AbstractBillService service = new AbstractBillService(new Connector());
        service.insert(constructBill());
        Bill bill = service.findById(NUM_CONTA).orElseThrow(ObjectNotFoundException::new);
        assertEquals(bill.getNumConta(), NUM_CONTA);
    }

    public Bill constructBill() {
        return new BillBuilder()
                .instalation(
                        InstalationBuilder.anInstalation()
                                .numInst("0874489555")
                                .address(
                                        AddressBuilder.anAddress()
                                                .zip("12289456")
                                                .street("Av. José Otávio de Macedo")
                                                .complement("")
                                                .num("615")
                                                .neighborhood("Jd. Panorama")
                                                .city("Caçapava")
                                                .uf("SP")
                                                .build()
                                )
                                .client(
                                        ClientBuilder.aClient()
                                                .name("GLOBO COMUNICACAO E PARTICIPACOES S/A")
                                                .CNPJ("27865757000102")
                                                .build()
                                )
                                .dealership(
                                        DealershipBuilder.aDealership()
                                                .id(1)
                                                .CNPJ("02302100000106")
                                                .initials("SABESP")
                                                .site("www.edponline.com.br")
                                                .build()
                                )
                                .build())
                .numConta(NUM_CONTA)
                .valor(new BigDecimal("93.35"))
                .vencimento(new DateTime().withDate(2020,7,3))
                .mesReferencia(new DateTime().withDate(2020,7,1))
                .periodoConsumo(31)
                .leituraAnterior(new DateTime().withDate(2020,5,20))
                .leituraAtual(new DateTime().withDate(2020,6,19))
                .leituraProxima(new DateTime().withDate(2020,7,20))
                .valorleituraAnterior(new BigDecimal("355"))
                .valorleituraAtual(new BigDecimal("338"))
                .build();
    }
}
