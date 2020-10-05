package com.tecsus.ddc.bills.energy.enums;

public enum ProductDescription {
    TUSD("TUSD - Consumo"),
    TE("TE - Consumo"),
    YELLOW_FLAG("Adicional bandeira Amarela"),
    RED_FLAG("Adicional bandeira Vermelha"),
    RED_2_FLAG("Adicional bandeira Vermelha II");

    private String description;

    ProductDescription(String description) {
        this.description = description;
    }

    public String get() {
        return description;
    }
}
