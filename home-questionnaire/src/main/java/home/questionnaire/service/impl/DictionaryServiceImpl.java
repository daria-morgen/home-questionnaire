package home.questionnaire.service.impl;

import home.questionnaire.properties.AppProperties;
import home.questionnaire.service.LibraryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.*;
import java.util.*;

@Service
public class DictionaryServiceImpl implements LibraryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DictionaryServiceImpl.class);
    //todo think about initialisation
    private boolean isHeadTag;
    private StringBuilder currentLine;
    private List<StringBuilder> dictionaryList;
    private Map<String, String> dictionaryMap;

    private DictionaryServiceImpl(AppProperties appProperties) {

        LOGGER.info(new Date() + ": Dictionary initialization start.");
        dictionaryList = new ArrayList<>();

        File file = new File(appProperties.getBotDictionaryFileName());

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String st;
        try {
            while (true) {
                assert br != null;
                if (!(st = br.readLine()).trim().equals("</xdxf>")) {
                    parseLine(st);
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert br != null;
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        prepareDictionaryMap();
        LOGGER.info(new Date() + ": Dictionary initialization end.");

    }

    private void parseLine(String line) {

        if (isHeadTag) {
            currentLine.append(line.trim());
        }
        if (line.contains("<ar>")) {
            currentLine = new StringBuilder();
            isHeadTag = true;
            currentLine.append(line.trim());

        }
        if (line.contains("</ar>")) {
            isHeadTag = false;
            currentLine.append(line.trim());
            try {
                dictionaryList.add(currentLine.replace(currentLine.indexOf("&quot;"), currentLine.indexOf("&quot;") + 5, "").replace(currentLine.indexOf("&quot;"), currentLine.indexOf("&quot;") + 5, "")
                );
            } catch (IndexOutOfBoundsException e) {
                dictionaryList.add(currentLine);
            }

        }
    }
    private void prepareDictionaryMap() {
        dictionaryMap = new HashMap<>();
        dictionaryList.forEach(e -> {
                    String value = e.substring(e.indexOf("<k>") + 3, e.indexOf("</k>"));
                    String key = e
                            .replace(e.indexOf("<ar>"), e.indexOf("</ar>"), "")
                            .replace(0, 5, "")
                            .substring(0, e.indexOf("</ar>"));


                    if (!key.equals("") && !value.equals("")) {
                        dictionaryMap.put(
                                key,
                                value
                        );
                    }
                }
        );
        LOGGER.info(new Date() + ": Dictionary init end. Dictionary size is: " + dictionaryMap.size());
    }

    public Mono<String> getTranslationFromRussianWord(String st) {
        if (dictionaryMap.containsValue(st)) {
            for (Map.Entry<String, String> entry : dictionaryMap.entrySet()) {
                String value = entry.getValue();
                if (value.equals(st)) {
                    return Mono.just(value);
                }
            }
        }

        return Mono.just("no translation");
    }

    @Override
    public Mono<String> getRandomRussianWord() {
        List<String> keys = new ArrayList<String>(dictionaryMap.keySet());
        return Mono.just(dictionaryMap.get(keys.get(new Random().nextInt(keys.size()))));
    }

    @Override
    public Mono<String> getRandomEnglishWord() {
        List<String> keys = new ArrayList<String>(dictionaryMap.keySet());
        return Mono.just(keys.get(new Random().nextInt(keys.size())));
    }

    @Override
    public Mono<String> getWordTranslation(String translationWord) {
        if (dictionaryMap.containsKey(translationWord)) {
            return Mono.just(dictionaryMap.get(translationWord));
        } else {
            return getTranslationFromRussianWord(translationWord);
        }
    }

}
