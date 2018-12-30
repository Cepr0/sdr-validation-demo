package io.github.cepr0.rest.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author Cepro, 2017-09-28
 */
@Data
public class Rate {

	@Min(1) @Max(5)
	@NotNull
	private Integer value;
}
