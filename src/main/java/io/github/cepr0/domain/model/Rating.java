package io.github.cepr0.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.Instant;

import static lombok.AccessLevel.PROTECTED;

/**
 * @author Cepro, 2017-09-28
 */
@Getter
@Setter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor
@Entity
public class Rating extends BaseEntity {

	@NaturalId
	@NotNull
	private Instant registered = Instant.now();

	@NaturalId
	@ManyToOne(optional = false)
	private User user;

	@NaturalId
	@ManyToOne(optional = false)
	private Book book;

	@Min(1) @Max(5)
	@NotNull
	private Integer rate;
}
