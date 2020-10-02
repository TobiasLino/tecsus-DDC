package com.tecsus.ddc.bills.energy;

import org.junit.Test;
import com.tecsus.ddc.bills.energy.builders.GroupBuilder;
import com.tecsus.ddc.bills.energy.enums.*;

/*
 *  @author Tobias Lino
 */
public class GroupTest {
    @Test
    public void groupBuilderTest() {
        Group group = new GroupBuilder()
                .group(Groups.A)
                .subGroup(Subgroups.A1)
                .classes(Classes.INDUSTRIAL)
                .modalities(Modalities.AZUL)
                .build();

    }
}
