package com.tecsus.ddc.bills.energy.builders;

import com.tecsus.ddc.bills.energy.Group;
import com.tecsus.ddc.bills.energy.enums.*;

public class GroupBuilder {


    private Groups group;
    private Subgroups subGroup;
    private Classes classes;
    private SubClasses subClasses;
    private Modalities modalities;
    private Posts posts;

    public Group build() {
        return new Group(group, subGroup, classes, subClasses, modalities);
    }

    public GroupBuilder group(final Groups group) {
        this.group = group;
        return this;
    }

    public GroupBuilder subGroup(final Subgroups subGroup) {
        this.subGroup = subGroup;
        return this;
    }

    public GroupBuilder classes(final Classes classes) {
        this.classes = classes;
        return this;
    }

    public GroupBuilder subClasses(final SubClasses subClasses) {
        this.subClasses = subClasses;
        return this;
    }

    public GroupBuilder modalities(final Modalities modalities) {
        this.modalities = modalities;
        return this;
    }

    public GroupBuilder posts(final Posts posts) {
        this.posts = posts;
        return this;
    }
}
