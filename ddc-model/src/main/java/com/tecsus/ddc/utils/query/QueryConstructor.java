package com.tecsus.ddc.utils.query;

import com.tecsus.ddc.bills.Bill;

/**
 * @author TOBIASDASILVALINO
 */
public interface QueryConstructor {
    QueryConstructor insert();
    QueryConstructor table(String table);
    <T> String values(T bill);
    QueryConstructor select();
}
