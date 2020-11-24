package com.tecsus.ddc.factory;

import com.tecsus.ddc.instalation.Instalation;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InstalationFactory implements Factory<Instalation> {

    @Override
    public Instalation constructFrom(ResultSet resultSet) {
        try {
            return Instalation.builder()
                .numInst(resultSet.getString("id_instalation"))
                .build();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
