package com.tecsus.ddc.controller.service;

import com.tecsus.ddc.controller.repository.InstalationRepository;
import com.tecsus.ddc.instalation.Instalation;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InstalationService {

    private final InstalationRepository instalationRepository;

    public Instalation teste() {
        return Instalation.builder().numInst("123456789").build();
    }
}
