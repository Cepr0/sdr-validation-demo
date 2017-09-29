package io.github.cepr0.rest.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;
import lombok.Value;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.stream.Collectors;

/**
 * A-la org.springframework.data.rest.webmvc.support.RepositoryConstraintViolationExceptionMessage
 *
 * @author Cepro, 2017-09-29 29.09.2017.
 */
@Value(staticConstructor = "of")
public class ConstraintViolationMessage {

	@JsonIgnore
	@NonNull List<FieldError> fieldErrors;

	@JsonIgnore
	@NonNull MessageSourceAccessor accessor;

	@JsonProperty("errors")
	public List<Error> getErrors() {
		return fieldErrors.stream()
				.map(fieldError -> Error.of(
						fieldError.getObjectName(),
						fieldError.getField(),
						fieldError.getRejectedValue(),
						accessor.getMessage(fieldError))
				).collect(Collectors.toList());
	}

	@Value(staticConstructor = "of")
	public static class Error {
		String entity, property;
		Object invalidValue;
		String message;
	}
}
