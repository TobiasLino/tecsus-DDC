package com.tecsus.ddc.client.builders;

import com.tecsus.ddc.client.Client;
import com.tecsus.ddc.client.Instalation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TOBIASDASILVALINO 
 */
public class ClientBuilder {
    
    private String CNPJ;
    private String companyName;
    private List<Instalation> instalations = new ArrayList<>();
    
    public Client build() {
        return new Client(CNPJ, companyName, instalations);
    }

    public ClientBuilder CNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
        return this;
    }

    public ClientBuilder companyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public ClientBuilder addInstalations(Instalation instalation) {
        this.instalations.add(instalation);
        return this;
    }
}
