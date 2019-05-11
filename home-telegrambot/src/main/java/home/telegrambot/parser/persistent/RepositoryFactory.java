package home.telegrambot.parser.persistent;

import home.telegrambot.parser.MessageKinds;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryFactory<T> {

    CrudRepository<T,Long> getRepository(MessageKinds messageKinds);
}
