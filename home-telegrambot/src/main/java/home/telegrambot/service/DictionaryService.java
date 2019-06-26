package home.telegrambot.service;

import java.util.List;

public interface DictionaryService {

    void initDictionary(List<String> dictionaryFilePath);

    String getWord();

}
