package game3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.regex.Pattern;
import java.io.IOException;

public class Utils {
  private static final String REGEX_DIGITS = "^[0-9]+$";

  public static int readIntInput() {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      try {
        String input = br.readLine();

        if (!Pattern.matches(REGEX_DIGITS, input)) {
          System.out.println("半角の数字を入力してください");
          continue;
        }

        return Integer.parseInt(input);
      } catch (IOException e) {
        System.out.println("入力エラーが発生しました。もう一度お試しください。");
      } catch (NumberFormatException e) {
        System.out.println("正しい数字を入力してください。");
      }
    }
  }

  public static String getMenuText(Map<Integer, String> menu) {
    StringBuilder sb = new StringBuilder();
    for (Map.Entry<Integer, String> entry : menu.entrySet()) {
      sb.append(entry.getKey()).append(":").append(entry.getValue()).append(" ");
    }

    return sb.toString();
  }
}
