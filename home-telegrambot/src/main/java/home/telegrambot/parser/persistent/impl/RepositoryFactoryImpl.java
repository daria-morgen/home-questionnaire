package home.telegrambot.parser.persistent.impl;

import home.telegrambot.datamanagement.model.Theme;
import home.telegrambot.datamanagement.model.Word;
import home.telegrambot.parser.MessageKinds;
import home.telegrambot.datamanagement.repository.ThemeRepository;
import home.telegrambot.datamanagement.repository.WordRepository;
import home.telegrambot.parser.persistent.RepositoryFactory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class RepositoryFactoryImpl implements RepositoryFactory {

    private final ThemeRepository themeRepository;

    private final WordRepository wordRepository;


    public RepositoryFactoryImpl(ThemeRepository themeRepository,
                                 WordRepository wordRepository) {
        this.themeRepository = themeRepository;
        this.wordRepository = wordRepository;
    }


    public CrudRepository getRepository(Word word){
                return wordRepository;

    };

    public CrudRepository getRepository(Theme word){
        return themeRepository;

    };
}
