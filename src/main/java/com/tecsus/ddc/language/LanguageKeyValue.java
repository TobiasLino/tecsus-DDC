package com.tecsus.ddc.language;

import lombok.Getter;

@Getter
public enum LanguageKeyValue {

    login_errors("Erro de login"),

    empty_username("Por favor, preencha o nome de usuário."),
    empty_password("Por favor, preencha a senha."),
    user_not_found("Usuário inválido."),
    wrong_password("A senha está errada.");

    private String text;

    LanguageKeyValue(String text) {
        this.text = text;
    }
}
