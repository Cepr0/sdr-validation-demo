package io.github.cepr0.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;

import static lombok.AccessLevel.PROTECTED;

/**
 * @author Cepro, 2017-09-28 28.09.2017.
 */
@Getter
@Setter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor
@Entity
public class Book extends BaseEntity {

	@Length(min = 3, max = 256)
	@NotBlank
	@NaturalId
	private String title;
}
