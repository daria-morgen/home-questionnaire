package home.telegrambot.bot;

import home.telegrambot.service.MessageService;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;


public class Bot extends TelegramLongPollingBot {

    private final Logger LOGGER = LoggerFactory.getLogger(Bot.class);

    private String botUsername;

    private String botToken;

    private RequestConfig requestConfig;

    private MessageService messageService;

    /**
     * Метод для приема сообщений.
     * @param update Содержит сообщение от пользователя.
     */
    @Override
    public void onUpdateReceived(Update update) {
        LOGGER.info("author : "+update.getMessage().getAuthorSignature());
        LOGGER.info("chat id: "+update.getMessage().getChatId().toString());
        LOGGER.info("message id: "+update.getMessage().getMessageId().toString());
        String message = update.getMessage().getText();
        sendMsg(update.getMessage().getChatId().toString(), message);

    }

    /**
     * Метод для настройки сообщения и его отправки.
     * @param chatId id чата
     * @param s Строка, которую необходимот отправить в качестве сообщения.
     */
    public synchronized void sendMsg(String chatId, String s) {

        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(messageService.getStringRequest(s));
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
//            log.log(Level.SEVERE, "Exception: ", e.toString());
        }
    }


    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    public static Bot getBot(String botUsername, String botToken
            ,MessageService messageService, String host, int port, int timeout
    ){
        Bot bot = new Bot();

        RequestConfig requestConfig = RequestConfig.custom()
                .setProxy(new HttpHost(host, port))
                        .setSocketTimeout(timeout)
                        .setConnectionRequestTimeout(timeout)
                        .setConnectTimeout(timeout)
                        .build();

        bot.getOptions().setRequestConfig(requestConfig);

        bot.botUsername=botUsername;
        bot.botToken=botToken;
        bot.messageService=messageService;
        return bot;
    }
}
