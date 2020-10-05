package com.tecsus.ddc.bills.energy;

import com.tecsus.ddc.bills.energy.enums.*;

/*
 * @author Tobias Lino
 */
public class Group {

    private Groups group;
    private Subgroups subGroup;
    private Classes classes;
    private SubClasses subClasses;
    private Modalities modalities;

    public Group(
            final Groups group,
            final Subgroups subGroup,
            final Classes classes,
            final SubClasses subClasses,
            final Modalities modalities) {
        this.group = group;
        this.subGroup = subGroup;
        this.classes = classes;
        this.subClasses = subClasses;
        this.modalities = modalities;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj == this) {
            return true;
        }
        if (obj instanceof Group) {
            Group g = (Group) obj;
            return group.equals(g.group)
                    && subGroup.equals(g.subGroup)
                    && classes.equals(g.classes)
                    && subClasses.equals(g.subClasses)
                    && modalities.equals(g.modalities);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Group{" +
                "group=" + group +
                ", subGroup=" + subGroup +
                ", classes=" + classes +
                ", subClasses=" + subClasses +
                ", modalities=" + modalities +
                '}';
    }

    public Groups getGroups() {
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

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(final Classes classes) {
        this.classes = classes;
    }

    public SubClasses getSubClasses() {
        return subClasses;
    }

    public void setSubClasses(final SubClasses subClasses) {
        this.subClasses = subClasses;
    }

    public Modalities getModalities() {
        return modalities;
    }

    public void setModalities(final Modalities modalities) {
        this.modalities = modalities;
    }
}
