package ua.oh.telegram_bot.bot;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
@Service
@RequiredArgsConstructor
public class BotService extends TelegramLongPollingBot {

  @Value("${telegram.bot.username}")
  private String username;
  @Value("${telegram.bot.token}")
  private String token;

  private final ReplyKeyboardFactory replyKeyboardFactory;

  @Override
  public String getBotUsername() {
    return username;
  }

  @Override
  public String getBotToken() {
    return token;
  }

  @Override
  public void onUpdateReceived(Update update) {

    log.info("Received new message: {}", update);

    echo(update);

  }

  private void echo(Update update) {
    String text = update.getMessage().getText();
    Long chatId = update.getMessage().getChatId();

    KeyboardRow keyboardRow = new KeyboardRow();
    keyboardRow.add("echo");

    ReplyKeyboardMarkup replyKeyboard = replyKeyboardFactory.getKeyboard(keyboardRow);
    SendMessage sendMessage = SendMessage
        .builder()
        .text(text)
        .chatId(chatId.toString())
        .replyMarkup(replyKeyboard)
        .build();

    try {
      //sending message via Telegram API
      this.sendApiMethod(sendMessage);
    } catch (TelegramApiException e) {
      log.error("Exception when sending message: ", e);
    }
  }

}
