package com.eniso.repositories;

import com.eniso.entities.Genre;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public class AbstractGenreRepository implements CrudRepository<Genre, Integer> {
    @Override
    public <S extends Genre> @NonNull S save(@NonNull S entity) {
        return null;
    }

    @Override
    public <S extends Genre> @NonNull S update(@NonNull S entity) {
        return null;
    }

    @Override
    public @NonNull <S extends Genre> List<S> updateAll(@NonNull Iterable<S> entities) {
        return List.of();
    }

    @Override
    public @NonNull <S extends Genre> List<S> saveAll(@NonNull Iterable<S> entities) {
        return List.of();
    }

    @Override
    public @NonNull Optional<Genre> findById(@NonNull Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(@NonNull Integer integer) {
        return false;
    }

    @Override
    public @NonNull List<Genre> findAll() {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(@NonNull Integer integer) {

    }

    @Override
    public void delete(@NonNull Genre entity) {

    }

    @Override
    public void deleteAll(@NonNull Iterable<? extends Genre> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
