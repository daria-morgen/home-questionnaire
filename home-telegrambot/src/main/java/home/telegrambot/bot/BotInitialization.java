package home.telegrambot.bot;


import home.telegrambot.service.MessageService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;

@Component
public class BotInitialization {

    public BotInitialization(AppProperties appProperties, MessageService service) {

        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

        try {
            telegramBotsApi.registerBot(Bot.getBot(appProperties.getBotUsername(),appProperties.getBotToken()
                    ,service
            ));

        } catch (Throwable e) {
            e.printStackTrace();
        }

    }

}
