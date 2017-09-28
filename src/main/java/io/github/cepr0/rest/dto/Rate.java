package io.github.cepr0.rest.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Value;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author Cepro, 2017-09-28 28.09.2017.
 */
@Validated
@Value
public class Rate {

	@Min(1) @Max(5)
	@NotNull
	private Integer value;
}
