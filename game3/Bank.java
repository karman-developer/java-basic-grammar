package game3;

import java.util.HashMap;
import java.util.Map;

public class Bank {
  private String bankName;
  private ATM atm;
  private Map<Integer, String> menu = new HashMap<>();

  public Bank(String bankName, String userName) {
    this.bankName = bankName;
    this.atm = new ATM(userName);
    menu.put(1, "ATM 利用");
    menu.put(2, "終了");
  }

  public String getBankName() {
    return bankName;
  }

  public void startService() {
    System.out.println(Utils.getMenuText(menu));
    int select = Utils.readIntInput();
    if (select == 1) {
      atm.run();
    } else {
      System.out.println("ご利用ありがとうございました、またのご利用お待ちしております");
    }
  }
}
