package home.questionnaire.telegrambot.parser;


import home.questionnaire.telegrambot.parser.persistent.Persistable;

public interface MessageParser {

    Persistable parse(String message);

}
