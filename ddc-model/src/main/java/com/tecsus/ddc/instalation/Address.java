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
public class Address {

    private String zip;
    private String street;
    private String num;
    private String complement;
    private String neighborhood;
    private String city;
    private String uf;
}
