package home.telegrambot.bot;

import home.telegrambot.service.PersistenceService;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    private String botUsername;

    private String botToken;

    private PersistenceService persistenceService;

    /**
     * Метод для приема сообщений.
     * @param update Содержит сообщение от пользователя.
     */
    @Override
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
        sendMsg(update.getMessage().getChatId().toString(), message);


//
//        if(update.hasMessage()) {
//            ThreadClass thread = new ThreadClass(update.getMessage());
//        } else  if(update.hasCallbackQuery()) {
//            AnswerCallbackThread answerThread = new AnswerCallbackThread(update.getCallbackQuery());
//        }

//        if (update.hasMessage() && update.getMessage().hasText()) {
//            String message_text = update.getMessage().getText();
//            long chat_id = update.getMessage().getChatId();
//            if (update.getMessage().getText().equals("/start")) {
//
//
//                SendMessage message = new SendMessage() // Create a message object object
//                        .setChatId(chat_id)
//                        .setText("You send /start");
//                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
//                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
//                List<InlineKeyboardButton> rowInline = new ArrayList<>();
//                rowInline.add(new InlineKeyboardButton().setText("Update message text").setCallbackData("update_msg_text"));
//                // Set the keyboard to the markup
//                rowsInline.add(rowInline);
//                // Add it to the message
//                markupInline.setKeyboard(rowsInline);
//                message.setReplyMarkup(markupInline);
//                try {
//                    execute(message); // Sending our message object to user
//                } catch (TelegramApiException e) {
//                    e.printStackTrace();
//                }
//            } else {
//
//            }
//
//        } else if (update.hasCallbackQuery()) {
//            // Set variables
//            String call_data = update.getCallbackQuery().getData();
//            long message_id = update.getCallbackQuery().getMessage().getMessageId();
//            long chat_id = update.getCallbackQuery().getMessage().getChatId();
//
//            if (call_data.equals("update_msg_text")) {
//                String answer = "Updated message text";
//                EditMessageText new_message = new EditMessageText()
//                        .setChatId(chat_id)
//                        .setMessageId(toIntExact(message_id))
//                        .setText(answer);
//                try {
//                    execute(new_message);
//                } catch (TelegramApiException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }


//        SendMessage message = InlineKeyboardBuilder.create(update.getMessage().getChatId())
//                .setText("Menu:")
//                .row()
//                .button("Action 1", "action-1")
//                .button("Action 2", "action-2")
//                .endRow()
//                .row()
//                .button("Action 3", "action-3")
//                .endRow()
//                .build();
//
//        try {
//            // Send the message
//            sendApiMethod(message);
//            //execute(message);
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
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
        sendMessage.setText(persistenceService.manageMessage(s));

        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
//            log.log(Level.SEVERE, "Exception: ", e.toString());
        }
    }

    /**
     * Метод возвращает имя бота, указанное при регистрации.
     * @return имя бота
     */
    @Override
    public String getBotUsername() {
        return botUsername;
    }

    /**
     * Метод возвращает token бота для связи с сервером Telegram
     * @return token для бота
     */
    @Override
    public String getBotToken() {
        return botToken;
    }

    public static Bot getBot(String botUsername, String botToken
            ,PersistenceService persistenceService
    ){
        Bot bot = new Bot();
        bot.botUsername=botUsername;
        bot.botToken=botToken;
        bot.persistenceService=persistenceService;
        return bot;
    }
}
