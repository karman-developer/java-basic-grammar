package system1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utils {
  public static int readIntInput(String message) {
    System.out.println(message);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      try {
        String input = br.readLine();
        return Integer.parseInt(input);
      } catch (IOException e) {
        System.out.println("入力エラーが発生しました。もう一度お試しください。");
      } catch (NumberFormatException e) {
        System.out.println("正しい数字を入力してください。");
      }
    }
  }
}
