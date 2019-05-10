package home.telegrambot.parser;

import home.telegrambot.model.Word;
import home.telegrambot.utils.Response;
import home.telegrambot.utils.ResponseError;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class BotMessageParser implements MessageParser {

    private String resultMessage;


    @Override
    public Response parse(String message) {

        List<String> msgs = Stream.of(message.split(" "))
                .map(String::new)
                .collect(Collectors.toList());

        Response response=null;
        if(msgs.size()!=0) {

            switch (MessageKinds.getType(msgs.get(0))) {
                case SAVE:
                    response = new Response(new Word(msgs.get(1), msgs.get(2), null));
                    break;
//            case RUN_TEST:
//                response =new Response(new TestServiceImpl());
//                break;
            }
        }

        return response;
    }
}
