package io.github.cepr0;

import io.github.cepr0.domain.model.Book;
import io.github.cepr0.domain.model.User;
import io.github.cepr0.domain.repo.BookRepo;
import io.github.cepr0.domain.repo.UserRepo;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import static java.util.Arrays.asList;

/**
 * @author Cepro, 2017-09-28 28.09.2017.
 */
@Component
@RequiredArgsConstructor
public class DemoData implements ApplicationRunner {

	@NonNull private final UserRepo userRepo;
	@NonNull private final BookRepo bookRepo;

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {

		userRepo.save(asList(
				new User("user1", "user1@demo.com"),
				new User("user2", "user2@demo.com")
		));

		bookRepo.save(asList(
				new Book("book1"),
				new Book("book2"),
				new Book("book3")
		));
	}
}
