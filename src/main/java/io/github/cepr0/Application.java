package io.github.cepr0;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

// @RequiredArgsConstructor
@SpringBootApplication
public class Application {

	// @NonNull private final MessageSource messageSource;
	// @NonNull private final LocalValidatorFactoryBean validatorFactoryBean;
	// @NonNull private final MethodValidationPostProcessor methodValidationPostProcessor;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	// @Bean
	public LocalValidatorFactoryBean localValidatorFactoryBean(MessageSource messageSource) {
		
		LocalValidatorFactoryBean validatorFactory = new LocalValidatorFactoryBean();
		validatorFactory.setValidationMessageSource(messageSource);
		return validatorFactory;
	}
	
	// @Bean
	// Validator validator() {
	// 	LocalValidatorFactoryBean validatorFactoryBean = new LocalValidatorFactoryBean();
	// 	validatorFactoryBean.setValidationMessageSource(messageSource);
	// 	// this.validatorFactoryBean.setValidationMessageSource(messageSource);
	// 	return validatorFactoryBean;
	// }

	// @Bean
	// public MethodValidationPostProcessor methodValidationPostProcessor() {
	//
	// 	// validatorFactoryBean.setValidationMessageSource(messageSource);
	// 	// validatorFactoryBean.setProviderClass(HibernateValidator.class);
	// 	// validatorFactoryBean.afterPropertiesSet();
	// 	MethodValidationPostProcessor postProcessor = new MethodValidationPostProcessor();
	// 	LocalValidatorFactoryBean validatorFactory = (LocalValidatorFactoryBean) validator();
	// 	validatorFactory.setValidationMessageSource(messageSource);
	// 	postProcessor.setValidator(validatorFactory.getValidator());
	// 	return postProcessor;
	// }

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

	// @Bean
	// public RepositoryRestConfigurerAdapter repositoryRestConfigurerAdapter() {
	// 	return new RepositoryRestConfigurerAdapter() {
	//
	// 		/**
	// 		 * Setting up validation for 'beforeCreate' and 'beforeSave' Repository events
	// 		 * <p>http://stackoverflow.com/a/36814513</p>
	// 		 */
	// 		@Override
	// 		public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener v) {
	// 			// validatorFactoryBean.setValidationMessageSource(messageSource);
	// 			// methodValidationPostProcessor.setValidator(validatorFactoryBean);
	// 			v.addValidator("beforeCreate", validatorFactoryBean);
	// 			v.addValidator("beforeSave", validatorFactoryBean);
	// 			// v.addValidator("beforeCreate", validator());
	// 			// v.addValidator("beforeSave", validator());
	// 			super.configureValidatingRepositoryEventListener(v);
	// 		}
	// 	};
	// }
}
