package com.tecsus.ddc.controller.service;

import java.util.List;
import java.util.Optional;

public interface BillService {

    Optional<Object> findById(String idBill);
    <T> List<T> findAll();
}
