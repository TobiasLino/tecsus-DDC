package com.tecsus.ddc.controller.service;

import com.tecsus.ddc.bills.energy.TariffFlag;
import com.tecsus.ddc.controller.repository.Repository;
import com.tecsus.ddc.controller.repository.TariffFlagRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class TariffFlagService {

    private final TariffFlagRepository tariffFlagRepository;

    public List<TariffFlag> findAll(final String id) {
        return tariffFlagRepository.findAllById(id);
    }
}
