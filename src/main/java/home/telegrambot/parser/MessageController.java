package home.telegrambot.parser;


public class MessageController {

    MessageParser messageParser;

    public MessageController() {
        this.messageParser = new BotMessageParser();
    }

    public String manageMessage(String message){

        String parse = messageParser.parse(message);


        return "response"; //todo
    };
}
