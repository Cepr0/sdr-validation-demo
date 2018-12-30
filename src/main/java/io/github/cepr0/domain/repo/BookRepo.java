package io.github.cepr0.domain.repo;

import io.github.cepr0.domain.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Cepro, 2017-09-28
 */
@RepositoryRestResource
public interface BookRepo extends JpaRepository<Book, Integer> {
}
