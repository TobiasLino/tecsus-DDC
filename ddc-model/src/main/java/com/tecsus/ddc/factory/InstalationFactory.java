package com.tecsus.ddc.factory;

import com.tecsus.ddc.instalation.Instalation;

import java.sql.ResultSet;

public class InstalationFactory implements Factory<Instalation> {

    @Override
    public Instalation constructFrom(ResultSet resultSet) {
        return Instalation.builder()
//            .numInst(rs.getString("num_inst"))
//                .address(Address.builder()
//                .zip(rs.getString("zip"))
//                .street(rs.getString("street"))
//                .num(rs.getString("num"))
//                .complement(rs.getString("complement"))
//                .neighborhood(rs.getString("neighborhood"))
//                .city(rs.getString("city"))
//                .uf(rs.getString("uf"))
//                .build())
            .build();
    }
}
