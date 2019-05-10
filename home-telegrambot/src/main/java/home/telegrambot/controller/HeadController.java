package home.telegrambot.controller;


import home.telegrambot.bot.Bot;
import home.telegrambot.service.PersistenceService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;

@Component
public class HeadController {

    private AppProperties appProperties;

    private PersistenceService service;

    private TelegramBotsApi telegramBotsApi;

    public HeadController(AppProperties appProperties,PersistenceService service) {
        this.service = service;
        this.appProperties=appProperties;

        ApiContextInitializer.init();
        telegramBotsApi = new TelegramBotsApi();

        try {
            telegramBotsApi.registerBot(Bot.getBot(appProperties.getBotUsername(),appProperties.getBotToken()
                    ,service
            ));

        } catch (Throwable e) {
            e.printStackTrace();
        }

    }


}
