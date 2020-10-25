package com.tecsus.ddc.query;

public interface QueryFactory {
    String createInsertQuery(final Object object);
    String createSelectQuery();
    String createSelectUniqueQuery(final String id);
}
