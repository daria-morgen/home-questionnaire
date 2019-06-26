package home.telegrambot.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppProperties {

    @Value("${botSource.botUserName:user}")
    private String botUsername;

    @Value("${botSource.botToken:token}")
    private String botToken;

    @Value("${botSource.botDictionaryFileName:botDictionaryFileName}")
    private String botDictionaryFileName;

    public String getBotUsername() {
        return botUsername;
    }

    public String getBotToken() {
        return botToken;
    }

    public String getBotDictionaryFileName() {
        return botDictionaryFileName;
    }
}
