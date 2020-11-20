package com.tecsus.ddc.bills.energy;

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
    private String description;
    private BigDecimal kWhQuantity;
    private BigDecimal fornecValue;
    private BigDecimal totalValue;

    private String billNum;
}
