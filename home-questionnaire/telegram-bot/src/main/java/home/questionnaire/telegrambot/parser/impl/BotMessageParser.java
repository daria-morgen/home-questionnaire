package home.questionnaire.telegrambot.parser.impl;

import home.questionnaire.telegrambot.parser.MessageParser;
import home.questionnaire.telegrambot.parser.persistent.Persistable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class BotMessageParser implements MessageParser {

    //todo think about parser
    private final Logger LOGGER = LoggerFactory.getLogger(BotMessageParser.class);

    @Override
    public Persistable parse(String message) {

        List<String> megs = Stream.of(message.split(" "))
                .map(String::new)
                .collect(Collectors.toList());

//        LOGGER.info("Count in message array: "+megs.size());

        if(megs.size()!=0) {

            switch (megs.get(0)) {
                case "word":
                    return null;
                case "theme":
                    return null;
                default:
                    return null;
            }
        }

        return null;
    }

}
