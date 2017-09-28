package io.github.cepr0.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.Identifiable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * @author Cepro, 2017-09-28 28.09.2017.
 */
@JsonInclude(NON_EMPTY)
@MappedSuperclass
@EqualsAndHashCode
public abstract class BaseEntity implements Identifiable<Integer> {

	@Id
	@GeneratedValue
	@Getter
	private final Integer id;

	protected BaseEntity() {
		this.id = null;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "[id=" + (getId() != null ? getId().toString() : null) + "]";
	}
}
