package com.group.telegram_bot;

import com.group.telegram_bot.config.BotConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    @Autowired
    BotConfig botConfig;
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            SendMessage message = new SendMessage();

            switch(messageText){
                case "/start":
                    message.setChatId(chatId);
                    message.setText("Добро пожаловать. Вы студент или преподаватель?");
                    break;
                case "студент":
                    message.setChatId(chatId);
                    message.setText("Добро пожаловать. Вы вошли как студент.");
                    break;
                case "преподвавтель":
                    message.setChatId(chatId);
                    message.setText("Добро пожаловать. Вы вошли как преподвавтель.");
                    break;
            }

            //message.setChatId(chatId);
            //message.setText(messageText);

            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }

}
