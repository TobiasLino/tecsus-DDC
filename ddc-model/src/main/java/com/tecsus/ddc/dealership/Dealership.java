package com.tecsus.ddc.dealership;

import com.tecsus.ddc.instalation.Instalation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TOBIASDASILVALINO
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Dealership {

    private int id;
    private String initials;
    private String CNPJ;
    private String site;
    private final List<Instalation> instalations = new ArrayList<>();
}
