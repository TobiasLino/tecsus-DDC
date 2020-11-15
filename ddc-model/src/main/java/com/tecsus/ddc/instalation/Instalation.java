package com.tecsus.ddc.instalation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author TOBIASDASILVALINO
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Instalation {

    private String numInst;
    private Address address;
}
