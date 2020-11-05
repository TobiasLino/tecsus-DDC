package com.tecsus.ddc.query;

public interface QueryFactory<T> {
    <S extends T> String createInsertQuery(final S object);
    <S extends T> String createInsertQuery(final S object, final String id);
    String createSelectQuery();
    String createSelectUniqueQuery(final String id);
    String createSelectUniqueQuery(final String id, final String column);
}
