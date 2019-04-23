package home.telegrambot.config;

import home.telegrambot.bot.Bot;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

@Configuration
public class BotConfig {

    @Value("${botSource.botUserName}")
    private String botUsername;

    @Value("${botSource.botToken}")
    private String botToken;

    @Bean
    public String configureBotSource() {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

        try {
            telegramBotsApi.registerBot(Bot.getBot(botUsername,botToken));
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }

        return "SUCCESS";
    }
}
