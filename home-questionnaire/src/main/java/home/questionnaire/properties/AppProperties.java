package home.questionnaire.properties;

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

    @Value("${botSource.proxyHost:host}")
    private String proxyHost;

    @Value("${botSource.proxyPort:port}")
    private int proxyPort;

    @Value("${botSource.timeout:timeout}")
    private int timeout;

    public String getBotUsername() {
        return botUsername;
    }

    public String getBotToken() {
        return botToken;
    }

    public String getBotDictionaryFileName() {
        return botDictionaryFileName;
    }

    public String getProxyHost() {
        return proxyHost;
    }

    public int getProxyPort() {
        return proxyPort;
    }

    public int getTimeout() {
        return timeout;
    }
}
