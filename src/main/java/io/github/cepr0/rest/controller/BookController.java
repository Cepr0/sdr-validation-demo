package io.github.cepr0.rest.controller;

import io.github.cepr0.rest.dto.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Cepro, 2017-09-28 28.09.2017.
 */
@RepositoryRestController
@RequestMapping("/books/{id}")
public class BookController {

	@Autowired
	private Validator validator;

	@Autowired
	@Qualifier("resourceDescriptionMessageSourceAccessor")
	private MessageSourceAccessor accessor;

	/**
	 * https://stackoverflow.com/a/44304198/5380322
	 * https://jira.spring.io/browse/DATAREST-593
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(validator);
	}
	
	@PutMapping("/rate")
	public ResponseEntity<?> rate(
			@PathVariable("id") Integer bookId,
			@RequestBody @Valid Rate rate,
			BindingResult result
	) {

		if (bookId != null) {

			if (result.hasErrors()) {
				return ResponseEntity
						.badRequest()
						.body(ConstraintViolationMessage.of(result.getFieldErrors(), accessor));
			}
			return ResponseEntity.ok(new Resource<>("Rated with " + rate));
		} else {
			throw new IllegalArgumentException("Book ID must not be null!");
		}
	}
}