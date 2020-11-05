package com.tecsus.ddc.bills.energy;

import com.tecsus.ddc.bills.energy.enums.Groups;
import com.tecsus.ddc.bills.energy.enums.Subgroups;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/*
 * @author Tobias Lino
 */
@AllArgsConstructor
@Data
@Builder
public class Group {

    private Groups group;
    private Subgroups subGroup;
}
