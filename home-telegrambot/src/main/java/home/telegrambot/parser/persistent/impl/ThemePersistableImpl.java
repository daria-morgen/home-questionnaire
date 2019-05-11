package home.telegrambot.parser.persistent.impl;


import home.telegrambot.datamanagement.model.Theme;
import home.telegrambot.parser.persistent.Persistable;
import org.springframework.data.repository.CrudRepository;

public class ThemePersistableImpl implements Persistable {

    private String name;

    private CrudRepository repositoryFactory;

    public ThemePersistableImpl(String name, CrudRepository repositoryFactory) {
        this.name = name;
        this.repositoryFactory = repositoryFactory;
    }

    @Override
    public void persist() {

        repositoryFactory.save(new Theme(this.name));

    }
}
