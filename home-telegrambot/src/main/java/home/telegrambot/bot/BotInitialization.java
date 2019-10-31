package home.telegrambot.bot;

import home.telegrambot.properties.AppProperties;
import home.telegrambot.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;

import java.util.Date;

//@Component
public class BotInitialization {
    private final Logger LOGGER = LoggerFactory.getLogger(BotInitialization.class);

    public BotInitialization(AppProperties appProperties, MessageService messageService) {
        LOGGER.info(new Date()+": Bot initialization start.");
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

        try {
            telegramBotsApi.registerBot(Bot.getBot(appProperties.getBotUsername(),appProperties.getBotToken()
                    ,messageService, appProperties.getProxyHost(),appProperties.getProxyPort(),appProperties.getTimeout()
            ));

        } catch (Throwable e) {
            e.printStackTrace();
        }

        LOGGER.info(new Date()+": Bot initialization end.");

    }

}
