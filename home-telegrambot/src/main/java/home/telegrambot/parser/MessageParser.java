package home.telegrambot.parser;


import home.telegrambot.parser.persistent.Persistable;

public interface MessageParser {

    Persistable parse(String message);

}
