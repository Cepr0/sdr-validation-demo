package io.github.cepr0;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Cepro, 2017-09-28
 */
@Configuration
@RequiredArgsConstructor
public class MvcConfig extends WebMvcConfigurerAdapter {
	
	@NonNull private final MessageSource messageSource;
	@NonNull private final LocalValidatorFactoryBean validatorFactoryBean;
	
	/**
	 * To validate @RestController methods
	 */
	@Override
	public Validator getValidator() {
		validatorFactoryBean.setValidationMessageSource(messageSource);
		return validatorFactoryBean;
	}
}
