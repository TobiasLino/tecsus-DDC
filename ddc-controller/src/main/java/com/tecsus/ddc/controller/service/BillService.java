package com.tecsus.ddc.controller.service;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public interface BillService {

    Optional<Object> findById(String idBill);
    <T> List<T> findAll();

    <T> List<T> executeSelect(String query);
    <T> List<T> responseToList(ResultSet rs);
}
