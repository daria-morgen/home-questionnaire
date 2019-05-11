package home.telegrambot.service.impl;


import home.telegrambot.parser.MessageParser;
import home.telegrambot.service.MessageService;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    private MessageParser messageParser;

    public MessageServiceImpl(MessageParser messageParser) {
        this.messageParser = messageParser;
    }

    public String manageMessage(String message){
        messageParser.parse(message).persist();
        return "success";
    }

}
