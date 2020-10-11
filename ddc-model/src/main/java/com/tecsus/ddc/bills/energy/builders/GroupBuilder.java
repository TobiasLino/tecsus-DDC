package com.tecsus.ddc.bills.energy.builders;

import com.tecsus.ddc.bills.energy.Group;
import com.tecsus.ddc.bills.energy.enums.Groups;
import com.tecsus.ddc.bills.energy.enums.Subgroups;

/**
 * @author TOBIASDASILVALINO 
 */
public class GroupBuilder {

    private Groups group;
    private Subgroups subGroup;
    
    public Group build() {
        return new Group(group, subGroup);
    }

    public GroupBuilder group(final Groups group) {
        this.group = group;
        return this;
    }

    public GroupBuilder subGroup(final Subgroups subGroup) {
        this.subGroup = subGroup;
        return this;
    }
}
