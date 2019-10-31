package home.telegrambot.bot;

import home.telegrambot.service.MessageService;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.Math.toIntExact;


public class Bot extends TelegramLongPollingBot {

    private final Logger LOGGER = LoggerFactory.getLogger(Bot.class);

    private String botUsername;

    private String botToken;

    private RequestConfig requestConfig;

    private MessageService messageService;

    private List<String> chatIdsList = new ArrayList<>();

    private Bot(String botUsername, String botToken, MessageService messageService) {
        this.botUsername = botUsername;
        this.botToken = botToken;
        this.messageService = messageService;
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {

        updates.forEach(update->{
            if (update.hasMessage() && update.getMessage().hasText()) {
                if(chatIdsList.contains(update.getMessage().getChatId().toString())) {
                    LOGGER.info("Added new chat id: " + update.getMessage().getChatId().toString()
                            + ", author : " + update.getMessage().getAuthorSignature()
                            + ", message id: " + update.getMessage().getMessageId().toString());

                    chatIdsList.add(update.getMessage().getChatId().toString());
                }

                SendMessage message = InlineKeyboardBuilder.create(update.getMessage().getChatId())
                        .setText(messageService.getStringRequest(""))
                        .row()
                        .button("translate 1", "translate-1")
                        .button("translate 2", "translate-2")
                        .endRow()
                        .build();

                    try {
                        execute(message); // Sending our message object to user
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }

            } else if (update.hasCallbackQuery()) {

                String answer = update.getCallbackQuery().getData();

                long message_id = update.getCallbackQuery().getMessage().getMessageId();
                long chat_id = update.getCallbackQuery().getMessage().getChatId();

                if (answer.equals("translate-1")) {
                    String result = "wrong";
                    EditMessageText new_message = new EditMessageText()
                            .setChatId(chat_id)
                            .setMessageId(toIntExact(message_id))
                            .setText(result);
                    try {
                        execute(new_message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override
    public void onUpdateReceived(Update update) {
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
            , MessageService messageService
    ) {
        return new Bot(botUsername, botToken, messageService);
    }
}
