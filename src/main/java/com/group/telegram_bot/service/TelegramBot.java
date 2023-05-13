package com.group.telegram_bot.service;

import com.group.telegram_bot.config.BotConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Component
public class TelegramBot{
/*
    @Autowired
    private UserRepository userRepository;
    final BotConfig config;

    public TelegramBot(BotConfig config){
        this.config = config;
        List<BotCommand> commandList = new ArrayList<>();
        commandList.add(new BotCommand("/start", "Добро пожаловать"));
        commandList.add(new BotCommand("/get", "Получить данные пользователя"));
        commandList.add(new BotCommand("/delete", "Удалить данные пользователя"));
        commandList.add(new BotCommand("/update", "Изменить данные пользователя"));
        commandList.add(new BotCommand("/help", "Посмотреть список команд"));
        commandList.add(new BotCommand("/settings", "Настройки"));

        try{
            this.execute(new SetMyCommands(commandList, new BotCommandScopeDefault(), null));
        }
        catch (TelegramApiException e){
            e.getMessage();
        }
    }

    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    @Override
    public String getBotToken(){
        return config.getToken();
    }


    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()){
            String messageText = update.getMessage().getText();

            long chatID = update.getMessage().getChatId();

            switch (messageText){
                case "/start":
                    registerUser(update.getMessage());
                    startReceived(chatID, update.getMessage().getChat().getFirstName());
                    break;
                case "/help":
                    sendMessage(chatID, "Бот написан с использованием Spring. Список команд: /start, \n\n /get, \n\n /delete, \n\n /update, \n\n /settings");
                    break;
                case "/get":
                    break;
                default:
                    sendMessage(chatID, "Команда не поддерживается");
                    break;
            }
        }
    }

    private void registerUser(Message message) {
        if(userRepository.findById(message.getChatId()).isEmpty()){
            var chatId = message.getChatId();
            var chat = message.getChat();

            User user = new User();
            user.setChatID(chatId);
            user.setFirstName(chat.getFirstName());
            user.setLastName(chat.getLastName());
            user.setUsername(chat.getUserName());
            user.setDor(new Timestamp(System.currentTimeMillis()));

            userRepository.save(user);
        }
    }


    private void startReceived(long chatID, String name){
        String result = "Добрый день, " + name;

        sendMessage(chatID, result);
    }

    private void sendMessage(long chatID, String msg){
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatID));
        message.setText(msg);

        try {
            execute(message);
        }
        catch (TelegramApiException e){
            e.getMessage();
        }
    }*/
}
