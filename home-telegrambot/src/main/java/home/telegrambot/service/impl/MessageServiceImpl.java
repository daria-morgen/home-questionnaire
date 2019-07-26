package home.telegrambot.service.impl;


import home.telegrambot.parser.MessageParser;
import home.telegrambot.service.LibraryService;
import home.telegrambot.service.MessageService;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    private MessageParser messageParser;

    private LibraryService libraryService;

    public MessageServiceImpl(MessageParser messageParser, LibraryService libraryService) {
        this.messageParser = messageParser;
        this.libraryService = libraryService;
    }

    //todo think about parser
    public String manageMessage(String message){
        messageParser.parse(message);
        return libraryService.getRandomWord().toString();
    }

    public String getStringRequest(String message){
        return manageMessage(message);
    }

}
