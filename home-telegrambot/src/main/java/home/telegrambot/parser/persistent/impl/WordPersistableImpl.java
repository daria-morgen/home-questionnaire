package home.telegrambot.parser.persistent.impl;

import home.telegrambot.datamanagement.model.Theme;
import home.telegrambot.datamanagement.model.Word;
import home.telegrambot.parser.persistent.Persistable;
import home.telegrambot.parser.persistent.RepositoryFactory;
import org.springframework.data.repository.CrudRepository;


public class WordPersistableImpl implements Persistable {

    private Word word;

    private RepositoryFactory repositoryFactory;

    public WordPersistableImpl(String cir_name,
                               String latin_name,
                               Theme theme,
                               RepositoryFactory repositoryFactory) {

        word = new Word(cir_name,latin_name,theme);
        this.repositoryFactory = repositoryFactory;
    }

    public WordPersistableImpl(String cir_name, String latin_name, RepositoryFactory repositoryFactory) {
        word = new Word(cir_name,latin_name);
        this.repositoryFactory = repositoryFactory;
    }

    @Override
    public void persist() {
        repositoryFactory.getRepository(word).save(word);
    }
}
