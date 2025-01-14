package com.eniso.repositories;

import com.eniso.entities.Genre;
import com.eniso.entities.SortingAndOrderArguments;
import io.micronaut.runtime.ApplicationConfiguration;
import io.micronaut.transaction.annotation.ReadOnly;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Singleton;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Singleton
public class GenreRepositoryImpl implements GenreRepository {

    private static final List<String> VALID_PROPERTY_NAMES = Arrays.asList("id", "name");

    private final EntityManager entityManager;
    private final ApplicationConfiguration applicationConfiguration;

    public GenreRepositoryImpl(EntityManager entityManager,
                               ApplicationConfiguration applicationConfiguration) {
        this.entityManager = entityManager;
        this.applicationConfiguration = applicationConfiguration;
    }

    @Override
    @ReadOnly
    public Optional<Genre> findById(long id) {
        return Optional.ofNullable(entityManager.find(Genre.class, id));
    }

    @Override
    @Transactional
    public Genre save(@NotBlank String name) {
        Genre genre = new Genre(name);
        entityManager.persist(genre);
        return genre;
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        findById(id).ifPresent(entityManager::remove);
    }

    @ReadOnly
    public List<Genre> findAll(@NotNull SortingAndOrderArguments args) {
        String qlString = "SELECT g FROM Genre as g";
        if (args.order() != null && args.sort() != null && VALID_PROPERTY_NAMES.contains(args.sort())) {
            qlString += " ORDER BY g." + args.sort() + ' ' + args.order().toLowerCase();
        }
        TypedQuery<Genre> query = entityManager.createQuery(qlString, Genre.class);
        if (args.offset() != null) {
            query.setFirstResult(args.offset());
        }
        return query.getResultList();
    }

    @Override
    @Transactional
    public int update(long id, @NotBlank String name) {
        return entityManager.createQuery("UPDATE Genre g SET name = :name where id = :id")
                .setParameter("name", name)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    @Transactional
    public Genre saveWithException(@NotBlank String name) {
        save(name);
        throw new PersistenceException();
    }
}