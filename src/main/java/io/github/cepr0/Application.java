package io.github.cepr0;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.HibernateValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@RequiredArgsConstructor
@SpringBootApplication
public class Application {

	@NonNull private final MessageSource messageSource;
	@NonNull private final LocalValidatorFactoryBean validatorFactoryBean;
//	@NonNull private final MethodValidationPostProcessor postProcessor;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Bean
//	LocalValidatorFactoryBean validator() {
//		validatorFactoryBean.setValidationMessageSource(messageSource);
//		return validatorFactoryBean;
//	}

//	@Bean
//	public MethodValidationPostProcessor methodValidationPostProcessor() {
//
//		validatorFactoryBean.setValidationMessageSource(messageSource);
//		validatorFactoryBean.setProviderClass(HibernateValidator.class);
//		validatorFactoryBean.afterPropertiesSet();
//
//		MethodValidationPostProcessor postProcessor = new MethodValidationPostProcessor();
//		postProcessor.setValidator(validatorFactoryBean);
//
//		return postProcessor;
//	}

//	@Bean
//	public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
//		return new WebMvcConfigurerAdapter() {
//
//			/**
//			 * Link local Validator ({@link LocalValidatorFactoryBean}) with {@link MessageSource} -
//			 * to get reloaded constraint validation messages in entities
//			 * <p>http://stackoverflow.com/a/32736788/5380322</p>
//			 */
//			@Override
//			public Validator getValidator() {
//				validatorFactoryBean.setValidationMessageSource(messageSource);
//				return validatorFactoryBean;
//			}
//		};
//	}


	@Bean
	public RepositoryRestConfigurerAdapter repositoryRestConfigurerAdapter() {
		return new RepositoryRestConfigurerAdapter() {

			/**
			 * Setting up validation for 'beforeCreate' and 'beforeSave' Repository events
			 * <p>http://stackoverflow.com/a/36814513</p>
			 */
			@Override
			public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener v) {

				v.addValidator("beforeCreate", validatorFactoryBean);
				v.addValidator("beforeSave", validatorFactoryBean);
				super.configureValidatingRepositoryEventListener(v);
			}
		};
	}
}
