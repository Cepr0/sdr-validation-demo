package io.github.cepr0.rest.controller;

import io.github.cepr0.rest.dto.Rate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Cepro, 2017-09-28 28.09.2017.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/books/{id}")
public class BookController {

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