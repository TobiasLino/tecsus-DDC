package com.tecsus.ddc.bills.energy;

import com.tecsus.ddc.bills.energy.enums.Classes;
import com.tecsus.ddc.bills.energy.enums.SubClasses;

/**
 * @author TOBIASDASILVALINO
 */
public class Classe {

    private Classes classe;
    private SubClasses subClasses;

    public Classe() {
    }

    public Classe(final Classes classe, final SubClasses subClasses) {
        this();
        this.classe = classe;
        this.subClasses = subClasses;
    }

    public Classes getClasse() {
        return classe;
    }

    public void setClasse(final Classes classe) {
        this.classe = classe;
    }

    public SubClasses getSubClasses() {
        return subClasses;
    }

    public void setSubClasses(final SubClasses subClasses) {
        this.subClasses = subClasses;
    }
}
