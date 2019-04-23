package home.telegrambot.parser;


public class BotMessageParser implements MessageParser {

    private String resultMessage;

    @Override
    public String parse(String message) {

        switch(MessageKinds.getType(message)){
            case SAVE:
                resultMessage="";
                break;
            case RUN_TEST:
                resultMessage="";
                break;
        }

        return resultMessage;
    }
}
