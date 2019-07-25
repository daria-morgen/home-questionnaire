package home.telegrambot.service.impl;

import home.telegrambot.properties.AppProperties;
import home.telegrambot.service.LibraryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class DictionaryServiceImpl implements LibraryService {

    private AppProperties properties;

    private List<String> dictionaryList;

    private Map<String, String> dictionaryMap;

    private static final Logger LOGGER = LoggerFactory.getLogger(DictionaryServiceImpl.class);

    private DictionaryServiceImpl(AppProperties appProperties) {
        this.properties=appProperties;

        LOGGER.info(new Date() + ": Dictionary initialization start.");
        dictionaryList = new ArrayList<>();

        File file = new File(properties.getBotDictionaryFileName());

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
                if ((st = br.readLine()).trim().equals("</xdxf>")) {
                    LOGGER.info(new Date() + ": Dictionary read break. Dictionary size is: " + dictionaryList.size());
                    break;
                }
                dictionaryList.add(st);
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
        LOGGER.info(new Date() + ": Dictionary initialization end.");


    }


    @Override
    public Mono<String> getRandomWord() {
        return null;
    }

    @Override
    public Mono<String> getWordTranslation(String translationWord) {
        return null;
    }
}
