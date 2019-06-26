package home.telegrambot.service.impl;


import home.telegrambot.parser.MessageParser;
import home.telegrambot.service.DictionaryService;
import home.telegrambot.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryServiceImpl implements DictionaryService {

    private List<String> dictionary;

    //todo think about initialization
    @Override
    public void initDictionary(List<String> dictionaryFilePath) {
      this.dictionary= dictionaryFilePath;
    }

    @Override
    public String getWord() {
        return dictionary.get(0);
    }
}
