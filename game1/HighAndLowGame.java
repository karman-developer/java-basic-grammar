package game1;

import java.util.List;
import java.util.ArrayList;

public class HighAndLowGame {
  private int earnedCoinCount;
  private int maxWinCoin = 10000;
  private int deckSetCount;

  public HighAndLowGame(int earnedCoinCount, int deckSetCount) {
    this.earnedCoinCount = earnedCoinCount;
    this.deckSetCount = deckSetCount;
  }

  public int execute() {
    List<Integer> cardList = new ArrayList<>();

    while (true) {
      getCard(cardList);

      if (earnedCoinCount > maxWinCoin) {
        return earnedCoinCount;
      }

      System.out.println("Your winCoin is " + earnedCoinCount);

      while (true) {
        System.out.print("Playing High And Low ? y / n : ");
        String input = GameUtils.getInputString();

        if ("y".equalsIgnoreCase(input)) {
          break;
        } else if ("n".equalsIgnoreCase(input)) {
          return earnedCoinCount;
        } else {
          System.out.println("Input error...Please retype!");
        }
      }

      boolean pickHigh;
      while (true) {
        System.out.print("High or Low ? h / l : ");
        String input = GameUtils.getInputString();
        if ("h".equalsIgnoreCase(input)) {
          pickHigh = true;
          break;
        } else if ("l".equalsIgnoreCase(input)) {
          pickHigh = false;
          break;
        } else {
          System.out.println("Input error...Please retype!");
        }
      }

      // 2
      getCard(cardList);

      boolean isWin = judgeCard(cardList, pickHigh);
      if (isWin) {
        earnedCoinCount *= 2;
      } else {
        earnedCoinCount = 0;
      }

      if (earnedCoinCount == 0) {
        System.out.println("You lost... Game Over.");
        return 0;
      } else {
        System.out.println("You got " + earnedCoinCount + " Coin !!");
      }
    }
  }

  private List<Integer> getCard(List<Integer> cardList) {
    int cardA;

    while (true) {
      cardA = GameUtils.getRandomInt(10) + 1;

      int count = 0;
      for (int card : cardList) {
        if (card == cardA) {
          count++;
        }
      }

      if (count < deckSetCount) {
        break;
      }
    }

    cardList.add(cardA);
    System.out.println("pick card --" + cardA + "--");

    return cardList;
  }

  private boolean judgeCard(List<Integer> cardList, boolean pickChoice) {
    int a = cardList.get(cardList.size() - 1);
    int b = cardList.get(cardList.size() - 2);

    if (a == b) {
      return false;
    }
    if (a > b) {
      return pickChoice;
    } else {
      return !pickChoice;
    }
  }

}