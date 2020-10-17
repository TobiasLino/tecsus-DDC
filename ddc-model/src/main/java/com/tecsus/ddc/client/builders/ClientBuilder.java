package com.tecsus.ddc.client.builders;

import com.tecsus.ddc.client.Client;

/**
 * @author TOBIASDASILVALINO
 */
public final class ClientBuilder {
    private Client client;

    private ClientBuilder() {
        client = new Client();
    }

    public static ClientBuilder aClient() {
        return new ClientBuilder();
    }

    public ClientBuilder CNPJ(String CNPJ) {
        client.setCNPJ(CNPJ);
        return this;
    }

    public ClientBuilder name(String name) {
        client.setName(name);
        return this;
    }

    public Client build() {
        return client;
    }
}
