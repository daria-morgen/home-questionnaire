package home.questionnaire.dictionaryparser;

import java.io.File;
import java.util.Map;

public interface DictionaryParser {

    /**
     *
     * @param file
     * @return map of translate word
     */
    Map<String, String> parsXDXFDictionary(File file);

}
