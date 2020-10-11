package com.tecsus.ddc.controller.exceptions;

import java.security.InvalidParameterException;

public class InvalidMonth extends InvalidParameterException {


    public void printError() {
        this.printStackTrace();
        System.out.println("Busca por mês inválido");
    }
}
