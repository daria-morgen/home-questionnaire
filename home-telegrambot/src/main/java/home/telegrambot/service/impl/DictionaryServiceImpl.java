package home.telegrambot.service.impl;

import home.telegrambot.properties.AppProperties;
import home.telegrambot.service.LibraryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.*;
import java.util.*;

@Service
public class DictionaryServiceImpl implements LibraryService {

    private boolean isHeadTag;

    private StringBuilder currentLine;

    private List<StringBuilder> dictionaryList;

    private Map<String, String> dictionaryMap;

    private static final Logger LOGGER = LoggerFactory.getLogger(DictionaryServiceImpl.class);

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

    public Mono<String> getTranslationFromEnglishWord(String st) {
        if (dictionaryMap.containsKey(st)) return Mono.just(dictionaryMap.get(st));
        return Mono.just("no translation");
    }

    public Mono<String> getTranslationFromRussianWord(String st) {
        if (dictionaryMap.containsValue(st)) {
            for (Map.Entry<String, String> entry : dictionaryMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (value.equals(st)) {
                    return Mono.just(value);
                }
            }
        }
        ;
        return Mono.just("no translation");
    }

    @Override
    public Mono<String> getRandomWord() {
        String randomWord = "";

//        dictionaryMap.

        return Mono.just(randomWord);
    }

    @Override
    public Mono<String> getWordTranslation(String translationWord) {
        if (dictionaryMap.containsValue(translationWord)) {
            return Mono.just(dictionaryMap.get(translationWord));
        } else {
            return getTranslationFromRussianWord(translationWord);
        }
    }
}
