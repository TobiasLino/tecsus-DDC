package com.tecsus.ddc.query;

import java.util.Optional;

public interface QueryFactory {
    Optional<String> createInsertQuery(final Object object);
    String createSelectQuery();
    String createSelectUniqueQuery(final String id);
}
