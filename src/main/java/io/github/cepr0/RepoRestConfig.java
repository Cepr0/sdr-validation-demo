package io.github.cepr0;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * @author Cepro, 2017-09-28
 */
@Configuration
@RequiredArgsConstructor
public class RepoRestConfig extends RepositoryRestConfigurerAdapter {
	
	@NonNull private final LocalValidatorFactoryBean validatorFactoryBean;
	
	@Override
	public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener v) {
		v.addValidator("beforeCreate", validatorFactoryBean);
		v.addValidator("beforeSave", validatorFactoryBean);
		super.configureValidatingRepositoryEventListener(v);
	}
}
