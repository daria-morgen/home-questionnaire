package home.telegrambot.parser.persistent.impl;


import home.telegrambot.datamanagement.model.Theme;
import home.telegrambot.parser.persistent.Persistable;
import home.telegrambot.parser.persistent.RepositoryFactory;

public class ThemePersistableImpl implements Persistable {

    private Theme theme;

    private RepositoryFactory repositoryFactory;

    public ThemePersistableImpl(String name, RepositoryFactory repositoryFactory) {
        theme=new Theme(name);
        this.repositoryFactory = repositoryFactory;
    }

    @Override
    public void persist() {
        repositoryFactory.getRepository(theme).save(theme);
    }
}
