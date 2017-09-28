package io.github.cepr0.rest.controller;

import io.github.cepr0.rest.dto.Rate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Cepro, 2017-09-28 28.09.2017.
 */
@RequiredArgsConstructor
@RepositoryRestController
@RequestMapping("/books/{id}")
public class BookController {
	
	@NonNull private final LocalValidatorFactoryBean validator;
	
	/**
	 * https://stackoverflow.com/a/44304198/5380322
	 * https://jira.spring.io/browse/DATAREST-593
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(validator);
	}
	
	@PutMapping("/rate")
	public ResponseEntity<?> rate(@PathVariable("id") Integer bookId, @Valid @RequestBody Rate rate, BindingResult bindingResult) {
		if (bookId != null) {

			if (bindingResult.hasErrors()) {
				return ResponseEntity.badRequest().body(new Resources<>(bindingResult.getFieldErrors()));
			}
			return ResponseEntity.ok(new Resource<>("Rated with " + rate));
		} else {
			throw new IllegalArgumentException("Book ID must not be null!");
		}
	}
}