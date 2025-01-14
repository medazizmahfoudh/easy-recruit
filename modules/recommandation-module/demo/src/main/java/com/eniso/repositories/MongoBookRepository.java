package com.eniso.repositories;

import com.eniso.entities.Book;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;

@MongoRepository
public interface MongoBookRepository extends CrudRepository<Book, Integer> {
}
