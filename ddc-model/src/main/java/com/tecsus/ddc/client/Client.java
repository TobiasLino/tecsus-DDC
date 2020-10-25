package com.tecsus.ddc.client;

import com.tecsus.ddc.instalation.Instalation;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TOBIASDASILVALINO
 */
@NoArgsConstructor
@Data
@Builder
public class Client {

    private String CNPJ;
    private String name;
    private final List<Instalation> instalations = new ArrayList<>();
}
