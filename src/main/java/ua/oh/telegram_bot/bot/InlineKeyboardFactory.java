package ua.oh.telegram_bot.bot;

import java.util.List;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

@Component
public class InlineKeyboardFactory {

  public InlineKeyboardMarkup getInlineKeyboard(List<List<InlineKeyboardButton>> rowsInLine,
      List<InlineKeyboardButton> rowInLine) {

    InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup();

    rowsInLine.add(rowInLine);
    inlineKeyboard.setKeyboard(rowsInLine);

    return inlineKeyboard;
  }

}
