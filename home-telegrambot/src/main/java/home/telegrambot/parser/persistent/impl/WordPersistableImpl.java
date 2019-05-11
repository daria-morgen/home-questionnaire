package home.telegrambot.parser.persistent.impl;

import home.telegrambot.datamanagement.model.Theme;
import home.telegrambot.datamanagement.model.Word;
import home.telegrambot.parser.persistent.Persistable;
import org.springframework.data.repository.CrudRepository;


public class WordPersistableImpl implements Persistable {

    private String cir_name;

    private String latin_name;

    private Theme theme;

    private CrudRepository repositoryFactory;

    public WordPersistableImpl(String cir_name,
                               String latin_name,
                               Theme theme,
                               CrudRepository repositoryFactory) {
        this.cir_name = cir_name;
        this.latin_name = latin_name;
        this.theme = theme;
        this.repositoryFactory = repositoryFactory;
    }

    public WordPersistableImpl(String cir_name, String latin_name, CrudRepository repositoryFactory) {
        this.cir_name = cir_name;
        this.latin_name = latin_name;
        this.repositoryFactory = repositoryFactory;
    }

    @Override
    public void persist() {
        repositoryFactory.save(
                new Word(this.cir_name,this.latin_name,this.theme));
    }
}
