package home.questionnaire.telegrambot.bot;

import home.questionnaire.telegrambot.properties.AppProperties;
import home.questionnaire.telegrambot.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;

import java.util.Date;

@Component
@EnableScheduling
public class BotInitialization {
    private final Logger LOGGER = LoggerFactory.getLogger(BotInitialization.class);

    private Bot bot;

    public BotInitialization(AppProperties appProperties, MessageService messageService) {
        LOGGER.info(new Date()+": Bot initialization start.");
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

        bot = Bot.getBot(appProperties.getBotUsername(),appProperties.getBotToken()
                ,messageService
        );

        try {
            telegramBotsApi.registerBot(bot);

        } catch (Throwable e) {
            e.printStackTrace();
        }

        LOGGER.info(new Date()+": Bot initialization end.");

    }

    @Scheduled(fixedDelay = 20000)
    private void shcedul(){
        LOGGER.info(new Date()+" - scheduler message");
        bot.sendMsgs();
    }

}
