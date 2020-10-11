package com.tecsus.ddc.bills.energy.builders;

import com.tecsus.ddc.bills.energy.Classe;
import com.tecsus.ddc.bills.energy.enums.Classes;
import com.tecsus.ddc.bills.energy.enums.SubClasses;

public class ClasseBuilder {

    private final Classe classe;

    public ClasseBuilder() {
        this.classe = new Classe();
    }

    public Classe build() {
        return this.classe;
    }

    public ClasseBuilder classe(Classes classes) {
        this.classe.setClasse(classes);
        return this;
    }

    public ClasseBuilder subClasse(SubClasses subclass) {
        this.classe.setSubClasses(subclass);
        return this;
    }
}
