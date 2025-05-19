package game3;

import java.util.HashMap;
import java.util.Map;

public class ATM {
  private String userName;
  private static final int MAX_DEPOSIT = 2_000_000;
  private static final int MAX_WITHDRAWAL = 500_000;

  private Map<Integer, String> menu = new HashMap<>();
  private int balance = 0;

  public ATM(String userName) {
    this.userName = userName;
    menu.put(1, "預け入れ");
    menu.put(2, "引き出し");
    menu.put(3, "残高照会");
    menu.put(4, "終了");
  }

  public void run() {
    System.out.println(userName + " 様ようこそ");

    while (true) {
      int userInput = getUserSelection();

      switch (userInput) {
        case 1 -> handleDeposit();
        case 2 -> handleWithdrawal();
        case 3 -> showBalance();
        case 4 -> {
          System.out.println("ATM のご利用ありがとうございました");
          return;
        }
        default -> System.out.println("未実装の機能です。");
      }
    }
  }

  private void handleDeposit() {
    while (true) {
      System.out.println("ご入金額を入力してください");
      int amount = Utils.readIntInput();
      if (amount >= 1 && amount <= MAX_DEPOSIT) {
        balance += amount;
        break;
      } else {
        System.out.println("1 円から " + MAX_DEPOSIT + " 円以内で入力してください");
      }
    }
  }

  private void handleWithdrawal() {
    if (balance == 0) {
      System.out.println("残高がありません");
      return;
    }

    System.out.println("ご出金額を入力してください");
    int amount = Utils.readIntInput();

    if (amount < 1 || amount > MAX_WITHDRAWAL) {
      System.out.println("1 円から " + MAX_WITHDRAWAL + " 円以内で入力してください");
    } else if (amount > balance) {
      System.out.println("残高が不足しています（現在の残高：" + balance + " 円）");
    } else {
      balance -= amount;
      System.out.println(amount + " 円を引き出しました");
    }
  }

  private void showBalance() {
    System.out.println("残高は " + balance + " 円です");
  }

  private int getUserSelection() {
    System.out.println(Utils.getMenuText(menu));
    return Utils.readIntInput();
  }
}
