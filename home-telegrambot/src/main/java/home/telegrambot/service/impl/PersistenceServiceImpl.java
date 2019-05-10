package home.telegrambot.service.impl;


import home.telegrambot.model.Theme;
import home.telegrambot.model.Word;
import home.telegrambot.parser.MessageParser;
import home.telegrambot.repository.ThemeRepository;
import home.telegrambot.repository.WordRepository;
import home.telegrambot.service.PersistenceService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class PersistenceServiceImpl implements PersistenceService {

    private final ThemeRepository themeRepository;

    private final WordRepository wordRepository;

    private MessageParser messageParser;

    public PersistenceServiceImpl(ThemeRepository themeRepository,
                                  WordRepository wordRepository,
                                  MessageParser messageParser) {
        this.themeRepository = themeRepository;
        this.wordRepository = wordRepository;
        this.messageParser = messageParser;
    }

    public String manageMessage(String message){
        Word word = (Word) messageParser.parse(message).getResult();
        saveObject(word);
        return "success"; //todo
    }

    private void saveObject(Word word){
        wordRepository.save(word);
    };

    private void saveObject(Theme theme){
        themeRepository.save(theme);
    };
}
