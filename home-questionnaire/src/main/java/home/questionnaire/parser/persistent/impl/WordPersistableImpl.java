package home.questionnaire.parser.persistent.impl;

import home.questionnaire.datamanagement.model.Theme;
import home.questionnaire.datamanagement.model.Word;
import home.questionnaire.parser.persistent.Persistable;
import home.questionnaire.parser.persistent.RepositoryFactory;


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
    }
}
