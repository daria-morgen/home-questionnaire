package home.questionnaire.parser.persistent.impl;


import home.questionnaire.datamanagement.model.Theme;
import home.questionnaire.parser.persistent.Persistable;
import home.questionnaire.parser.persistent.RepositoryFactory;

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
