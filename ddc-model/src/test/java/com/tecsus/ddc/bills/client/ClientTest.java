package com.tecsus.ddc.bills.client;

import com.tecsus.ddc.client.Address;
import com.tecsus.ddc.client.Instalation;
import com.tecsus.ddc.client.builders.AddressBuilder;
import com.tecsus.ddc.client.builders.ClientBuilder;
import com.tecsus.ddc.client.Client;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author TOBIASDASILVALINO
 */
public class ClientTest {

    public Client buildClient() {
        Address botanico = new AddressBuilder()
                .zip("22.460-901")
                .street("R LOPES QUINTAS")
                .number("303")
                .neighborhood("JARDIM BOTANICO")
                .city("RIO DE JANEIRO")
                .uf("SP")
                .complement("")
                .build();
        Address panorama = new AddressBuilder()
                .zip("22.478-201")
                .street("R José César Marcondes")
                .number("1110")
                .neighborhood("Panorama")
                .city("RIO DE JANEIRO")
                .uf("SP")
                .complement("")
                .build();
        Instalation botInst = new Instalation(112354866, botanico);
        Instalation panInst = new Instalation(112354867, panorama);

        return new ClientBuilder()
                .CNPJ("27865757000102")
                .companyName("GLOBO COMUNICACAO E PARTICIPACOES S/A")
                .addInstalations(botInst)
                .addInstalations(panInst)
                .build();
    }

    @Test
    public void clientBuilderTest() {
        Client c = new ClientTest().buildClient();

        // TODO: Asserts
    }
}
