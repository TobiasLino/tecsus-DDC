package com.tecsus.ddc.bills.energy.enums;

public enum ProductDescription {
    TUSD("0605", "TUSD - Consumo"),
    TE("0601", "TE - Consumo"),
    YELLOW_FLAG("0698", "Adicional bandeira Amarela"),
    RED_FLAG("0698", "Adicional bandeira Vermelha"),
    RED_2_FLAG("0698", "Adicional bandeira Vermelha II");

    private String cci;
    private String description;

    ProductDescription(final String cci, final String description) {
        this.cci = cci;
        this.description = description;
    }

    public String getCci() {
        return cci;
    }

    public String getDescription() {
        return description;
    }
}
