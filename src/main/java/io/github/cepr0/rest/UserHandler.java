package io.github.cepr0.rest;

import io.github.cepr0.domain.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Slf4j
@RepositoryEventHandler
@Component
public class UserHandler {

	@HandleBeforeSave
	public void BeforeSaveHandler(User user) {
		log.info("[i] User: {}", user);
	}
}
