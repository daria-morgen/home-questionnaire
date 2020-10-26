package home.questionnaire.telegrambot.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface MessageService {

    SendMessage manageMessageRequest(Update updates);

    EditMessageText manageMessageResponse(Update updates);
}
