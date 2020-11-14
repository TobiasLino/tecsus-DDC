package com.tecsus.ddc.instalation;

import com.tecsus.ddc.client.Client;
import com.tecsus.ddc.dealership.Dealership;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

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
