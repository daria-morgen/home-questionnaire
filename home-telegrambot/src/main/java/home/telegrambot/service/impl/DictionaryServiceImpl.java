package home.telegrambot.service.impl;

import home.telegrambot.service.DictionaryService;
import org.springframework.stereotype.Service;


@Service
public class DictionaryServiceImpl implements DictionaryService {

    private Dictionary dictionary;

    //todo think about initialization
    @Override
    public void initDictionary(String dictionaryFilePath) {
      this.dictionary= Dictionary.getDictionary(dictionaryFilePath);
    }

}
