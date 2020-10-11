package com.tecsus.ddc.controller.exceptions;

public class EmptyResponseBody extends Exception {

    public void printError() {
        this.printStackTrace();
        System.out.println("The method returned a Empty Response body.");
    }
}
