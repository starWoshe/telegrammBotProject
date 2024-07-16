package ua.javarush;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static ua.javarush.TelegramBotContent.*;
import static ua.javarush.TelegramBotUtils.*;

public class MyFirstTelegramBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "opanas42442_jru_bot";
    }

    @Override
    public String getBotToken() {
        return "7433592234:AAGfehL66xPWsuLQ6SZYhPSRX4EHJEedJSI";
    }

    @Override
    public void onUpdateReceived(Update update) {
        Long chatId = getChatId(update);

        if (update.hasMessage() && update.getMessage().getText().equals("/start")) {
            SendMessage message = createMessage(chatId, "Привіт *Ґамлєт*, _ходімо_ в кабінєт!");
            sendApiMethodAsync(message);
        }

        if (update.hasMessage() && update.getMessage().getText().toLowerCase().contains("привіт")) {
            SendMessage message = createMessage(chatId, "Ти хто? Як звать тебе? То може ти ще й *сала* не їси?");
            sendApiMethodAsync(message);
        }

        if (update.hasMessage() &&
                (update.getMessage().getText().toLowerCase().contains("їм") ||
                        update.getMessage().getText().toLowerCase().contains("їдю") ||
                        update.getMessage().getText().toLowerCase().contains("обожнюю") ||
                        update.getMessage().getText().toLowerCase().contains("люблю") ||
                        update.getMessage().getText().toLowerCase().contains("тащусь"))) {
            SendMessage message = createMessage(chatId, "Я знав, ти _друг_, я ж *кіт*.");
            sendApiMethodAsync(message);
            return;
        }

        if (update.hasMessage()) {
            SendMessage message = createMessage(chatId, "Забирай свої тракторці та іди з мого пісочку, _непевний_ *типе*!");
            sendApiMethodAsync(message);
        }
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}