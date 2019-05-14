package home.telegrambot.parser.persistent;

import home.telegrambot.datamanagement.model.Theme;
import home.telegrambot.datamanagement.model.Word;
import home.telegrambot.parser.MessageKinds;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryFactory<T> {

    CrudRepository<T,Long> getRepository(Word word);

    CrudRepository<T,Long> getRepository(Theme theme);
}
