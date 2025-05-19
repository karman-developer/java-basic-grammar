package system1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
  private Map<Integer, Drink> drinks = new HashMap<Integer, Drink>();
  DepositManager depositManager = new DepositManager();

  Drink drink1 = new Drink("コーラ", 100, 2);
  Drink drink2 = new Drink("お茶", 150, 1);
  Drink drink3 = new Drink("コーヒー", 120, 0);

  public VendingMachine() {
    drinks.put(1, drink1);
    drinks.put(2, drink2);
    drinks.put(3, drink3);
  }

  public void printDrinks() {
    while (true) {
      if (isAllSoldOut()) {
        System.out.println("全て売り切れました");
        break;
      }

      System.out.println("---------------------------");
      for (Map.Entry<Integer, Drink> entry : drinks.entrySet()) {
        System.out.println(entry.getKey() + ": " + entry.getValue().getDisplayInfo());
      }
      System.out.println("---------------------------");
      userSelect();
    }
  }

  public int userInputData() {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      System.out.println("商品を選択してください");
      try {
        String input = br.readLine();
        int num = Integer.parseInt(input);
        if (num >= 1 && num <= 3) {
          return num;
        }
      } catch (IOException e) {
        // 入力エラーは無視してループ続行
      } catch (NumberFormatException e) {
        // 数字以外は無視してループ続行
      }
    }
  }

  public void userSelect() {
    Drink selectedDrink;

    while (true) {
      int selected = userInputData();
      selectedDrink = drinks.get(selected);

      if (selectedDrink.getStocks() == 0) {
        System.out.println("売り切れです");
        continue;
      }

      break;
    }
    putMoney(selectedDrink);
  }

  public void putMoney(Drink selectedDrink) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    depositManager.resetDeposit();

    while (true) {
      System.out.println("お金を入れてください");

      try {
        String input = br.readLine();
        int money = Integer.parseInt(input);

        if (money <= 0) {
          continue;
        }

        depositManager.addDeposit(money);

        int currentDeposit = depositManager.getDeposit();

        if (selectedDrink.getPrice() > currentDeposit) {
          System.out.println("入金額が足りません 現在の投入金額 " + currentDeposit + "円");
        } else {
          selectedDrink.setStocks(selectedDrink.getStocks() - 1);
          System.out.println(selectedDrink.getName() + " を購入しました");

          int change = currentDeposit - selectedDrink.getPrice();
          if (change > 0) {
            System.out.println(change + " 円のお返しです");
          }

          break;
        }
      } catch (IOException e) {
        //
      } catch (NumberFormatException e) {
        //
      }
    }
  }

  public boolean isAllSoldOut() {
    for (Drink drink : drinks.values()) {
      if (drink.getStocks() > 0) {
        return false;
      }
    }
    return true;
  }

}
