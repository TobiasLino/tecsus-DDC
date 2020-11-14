package com.tecsus.ddc.bills.energy;

import com.tecsus.ddc.bills.energy.enums.Classes;
import com.tecsus.ddc.bills.energy.enums.SubClasses;
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
public class Classe {

    private Classes classe;
    private SubClasses subClasses;
}
