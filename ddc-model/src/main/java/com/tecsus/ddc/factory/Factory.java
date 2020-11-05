package com.tecsus.ddc.factory;

import java.sql.ResultSet;

public interface Factory<T> {

    T constructFrom(final ResultSet resultSet);
}
