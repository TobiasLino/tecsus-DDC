package com.tecsus.ddc.controller.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {

    <S extends T> void saveAll(Iterable<S> var1);

    List<T> findAll();

    Optional<T> findById(final String id);

    <S extends T> void save(S var1);

    <S extends T> void update(S var1);
}
