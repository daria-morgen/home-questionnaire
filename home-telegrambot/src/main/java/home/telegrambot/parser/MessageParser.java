package home.telegrambot.parser;


import home.telegrambot.utils.Response;

public interface MessageParser {

    Response parse(String message);

}
