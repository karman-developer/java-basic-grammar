package system1;

public class DepositManager {
  private int deposit = 0;

  public int getDeposit() {
    return deposit;
  }

  public void setDeposit(int deposit) {
    this.deposit = deposit;
  }

  public void addDeposit(int amount) {
    deposit += amount;
  }

  public void resetDeposit() {
    deposit = 0;
  }
}
