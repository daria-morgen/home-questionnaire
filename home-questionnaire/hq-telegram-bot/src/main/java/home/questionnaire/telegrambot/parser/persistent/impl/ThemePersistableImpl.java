package home.questionnaire.telegrambot.parser.persistent.impl;


import home.questionnaire.telegrambot.model.Theme;
import home.questionnaire.telegrambot.parser.persistent.Persistable;
import home.questionnaire.telegrambot.parser.persistent.RepositoryFactory;

public class ThemePersistableImpl implements Persistable {

    private Theme theme;

    private RepositoryFactory repositoryFactory;

    public ThemePersistableImpl(String name, RepositoryFactory repositoryFactory) {
        theme=new Theme(name);
        this.repositoryFactory = repositoryFactory;
    }

    @Override
    public void persist() {
    }
}
