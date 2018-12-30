package io.github.cepr0;

import io.github.cepr0.rest.UserValidator;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * @author Cepro, 2017-09-28
 */
@Configuration
@RequiredArgsConstructor
public class RepoRestConfig implements RepositoryRestConfigurer {
	
	@NonNull private final LocalValidatorFactoryBean validatorFactoryBean;
	
	@Override
	public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener v) {
		v.addValidator("beforeCreate", validatorFactoryBean);
		v.addValidator("beforeSave", validatorFactoryBean);
		v.addValidator("beforeSave", new UserValidator());
	}
}
