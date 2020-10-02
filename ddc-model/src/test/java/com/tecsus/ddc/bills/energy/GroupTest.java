package com.tecsus.ddc.bills.energy;

import org.junit.Assert;
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

        Assert.assertEquals(Groups.A, group.getGroups());
        Assert.assertEquals(Subgroups.A1, group.getSubGroup());
        Assert.assertEquals(Classes.INDUSTRIAL, group.getClasses());
        Assert.assertEquals(Modalities.AZUL, group.getModalities());
    }
}
