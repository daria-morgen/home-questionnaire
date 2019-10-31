package home.telegrambot.service.impl;

import home.telegrambot.bot.InlineKeyboardBuilder;
import home.telegrambot.parser.MessageParser;
import home.telegrambot.service.LibraryService;
import home.telegrambot.service.MessageService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;

import static java.lang.Math.toIntExact;

@Service
public class MessageServiceImpl implements MessageService {

    private MessageParser messageParser;

    private LibraryService libraryService;

    public MessageServiceImpl(MessageParser messageParser, LibraryService libraryService) {
        this.messageParser = messageParser;
        this.libraryService = libraryService;
    }

    @Override
    public SendMessage manageMessageRequest(Update update) {
        String question = libraryService.getRandomEnglishWord().block();
        return InlineKeyboardBuilder.create(update.getMessage().getChatId())
                .setText(question)
                .row()
                .button(libraryService.getRandomRussianWord().block(), libraryService.getRandomRussianWord().block())
                .button(libraryService.getWordTranslation(question).block(), libraryService.getWordTranslation(question).block())
                .endRow()
                .build();
    }

    @Override
    public EditMessageText manageMessageResponse(Update update) {

        if (!update.getCallbackQuery().getData().equals(libraryService.getWordTranslation(update.getCallbackQuery().getMessage().getText()).block()))
            return new EditMessageText()
                    .setChatId(update.getCallbackQuery().getMessage().getChatId())
                    .setMessageId(toIntExact(update.getCallbackQuery().getMessage().getMessageId()))
                    .setText("Not right =(");
        return new EditMessageText()
                .setChatId(update.getCallbackQuery().getMessage().getChatId())
                .setMessageId(toIntExact(update.getCallbackQuery().getMessage().getMessageId()))
                .setText("Right!");

    }

}
