package com.tecsus.ddc.controller.repository;

import com.tecsus.ddc.instalation.Instalation;

import java.util.List;
import java.util.Optional;

public class InstalationRepository implements Repository<Instalation> {
    @Override
    public <S extends Instalation> void saveAll(Iterable<S> var1) {

    }

    @Override
    public List<Instalation> findAll() {
        return null;
    }

    @Override
    public Optional<Instalation> findById(String id) {
        return Optional.empty();
    }

    @Override
    public <S extends Instalation> void save(S var1) {

    }

    @Override
    public <S extends Instalation> void update(S var1) {

    }
}
