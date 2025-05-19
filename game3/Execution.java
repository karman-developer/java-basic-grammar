package game3;

public class Execution {
  public static void main(String[] args) {
    Bank bank = new Bank("KRY銀行", "鈴木一郎");
    System.out.println("いらっしゃいませ、ようこそ " + bank.getBankName() + " へ");
    bank.startService();
  }
}
