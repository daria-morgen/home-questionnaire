package home.telegrambot.service.impl;


import home.telegrambot.parser.MessageParser;
import home.telegrambot.service.DictionaryService;
import home.telegrambot.service.MessageService;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    private MessageParser messageParser;

    private DictionaryService dictionaryService;

    public MessageServiceImpl(MessageParser messageParser, DictionaryService dictionaryService) {
        this.messageParser = messageParser;
        this.dictionaryService=dictionaryService;
    }

    //todo think about parser
    public String manageMessage(String message){
        messageParser.parse(message);
        return "success";
    }

    public String getStringRequest(String message){
        return manageMessage(message);
    }

}
