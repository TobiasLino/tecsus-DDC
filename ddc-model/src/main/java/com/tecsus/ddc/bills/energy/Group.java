package com.tecsus.ddc.bills.energy;

import com.tecsus.ddc.bills.energy.enums.*;

/*
 * @author Tobias Lino
 */
public class Group {

    private Groups group;
    private Subgroups subGroup;

    public Group(final Groups group, final Subgroups subGroup) {
        this.group = group;
        this.subGroup = subGroup;
    }

    public Groups getGroup() {
        return group;
    }

    public void setGroup(final Groups group) {
        this.group = group;
    }

    public Subgroups getSubGroup() {
        return subGroup;
    }

    public void setSubGroup(final Subgroups subGroup) {
        this.subGroup = subGroup;
    }
}
