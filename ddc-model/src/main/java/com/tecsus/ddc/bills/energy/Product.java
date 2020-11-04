package com.tecsus.ddc.bills.energy;

import com.tecsus.ddc.bills.energy.enums.ProductDescription;
import com.tecsus.ddc.bills.tributes.Tribute;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author TOBIASDASILVALINO
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {

    private Integer id;
    private ProductDescription description;
    private BigDecimal kWhQuantity;
    private BigDecimal tariff;
    private BigDecimal fornecValue;
    private BigDecimal tariffWithTributes;
    private BigDecimal calcBaseICMS;
    private BigDecimal aliqICMS;    // %
    private BigDecimal valueICMS;
    private Tribute PIS;
    private Tribute COFINS;
    private BigDecimal totalValue;
}
