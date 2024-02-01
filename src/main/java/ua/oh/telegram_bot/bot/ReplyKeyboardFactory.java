package ua.oh.telegram_bot.bot;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

@Component
public class ReplyKeyboardFactory {

  public ReplyKeyboardMarkup getKeyboard(KeyboardRow row) {

    ReplyKeyboardMarkup replyKeyboard = new ReplyKeyboardMarkup();
    replyKeyboard.setResizeKeyboard(true);
    replyKeyboard.setSelective(false);

    List<KeyboardRow> keyboardRows = new ArrayList<>();

    keyboardRows.add(row);
    replyKeyboard.setKeyboard(keyboardRows);
    return replyKeyboard;

  }

}
