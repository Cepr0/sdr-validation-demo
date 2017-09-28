package io.github.cepr0.domain.repo;

import io.github.cepr0.domain.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Cepro, 2017-09-28 28.09.2017.
 */
@RepositoryRestResource(exported = false)
public interface RatingRepo extends JpaRepository<Rating, Integer> {
}
