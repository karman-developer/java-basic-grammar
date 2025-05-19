package game2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Janken {
  private Map<Integer, String> hands = new HashMap<Integer, String>();
  private List<String> result = new ArrayList<String>();

  private int winCount = 0;
  private int loseCount = 0;
  private int drawCount = 0;

  public Janken() {
    hands.put(1, "グー");
    hands.put(2, "チョキー");
    hands.put(3, "パー");

    result.add("あいこ");
    result.add("負け");
    result.add("勝ち");
  }

  public void execution() {
    int playerHand = getUserInput();
    int cpuHand = getAutoInput();
    getResult(playerHand, cpuHand);
  }

  private void printHands() {
    for (Map.Entry<Integer, String> entry : hands.entrySet()) {
      System.out.print(entry.getKey() + ":" + entry.getValue() + " ");
    }
    System.out.println();
  }

  private String getUserInputRaw() {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    try {
      return br.readLine();
    } catch (IOException e) {
      System.out.println("Input error...Please retype!");
      return null;
    }
  }

  private boolean isValidInput(String input, int min, int max) {
    if (input == null)
      return false;
    try {
      int value = Integer.parseInt(input);
      return value >= min && value <= max;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  private int getUserInput() {
    while (true) {
      printHands();
      System.out.println("PLAYER");
      String input = getUserInputRaw();
      if (isValidInput(input, 1, 3)) {
        return Integer.parseInt(input);
      } else {
        System.out.println("該当する半角数字で入力してください");
      }
    }
  }

  // CPU
  private int getRandomInt() {
    Random random = new Random();
    int num = random.nextInt(3) + 1;
    System.out.println(num);
    return num;
  }

  private int getAutoInput() {
    System.out.println("CPU");
    return getRandomInt();
  }

  // Win or lose
  private void getResult(int player, int cpu) {
    if (player == cpu) {
      System.out.println("結果：" + result.get(0));
      drawCount++;
    } else if ((player == 1 && cpu == 2) ||
        (player == 2 && cpu == 3) ||
        (player == 3 && cpu == 1)) {
      System.out.println("結果：" + result.get(2));
      winCount++;
    } else {
      System.out.println("結果：" + result.get(1));
      loseCount++;
    }
  }

  // 試合（メインループ）
  public void start() {
    while (true) {
      execution();

      while (true) {
        System.out.println("1:もう一度対戦する 2:終了する");
        String input = getUserInputRaw();

        if (!isValidInput(input, 1, 2)) {
          System.out.println("該当する半角数字で入力してください");
          continue;
        }

        if (Integer.parseInt(input) == 2) {
          System.out.println("最終結果：" +
              winCount + "勝 " +
              loseCount + "敗 " +
              drawCount + "引き分け");
          return;
        } else {
          break;
        }
      }
    }
  }
}
